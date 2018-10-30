var ctx = $('#ctx').val()
$(function () {
    var $submit_btns = $('.key-submit')
    var $save_btns = $('.key-save')
    var empId = $('#employee').data('emp')
    var $target;
    var empty = 0;

    $submit_btns.on('click', function (e) {
        var $trs = $(this).parent().parent().find("tr[data-task]");
        var data = getFormData($trs, empId);

        $('#tip-modal').modal('show');

        $('#tip-modal').one('shown.bs.modal', function (e) {
            if(empty == 0) {
                $('#tip-body').html('<p class="bg-success">已填完所有项！</p>')
            } else {
                $('#tip-body').html('<p>还剩<span class="text-danger">' + empty + '</span>项未完成，是否继续提交？</p>')
            }
        })

        $('#confirm').on('click', function () {
            $.ajax({
                type: 'POST',
                data: JSON.stringify(data),
                url: ctx + '/keyWork_evaluate',
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    if(data['result'] == 'Y') {
                        init($target)
                        $('#tip-modal').modal('hide')
                    }
                }
            })
        })

    })

    $save_btns.on('click', function (e) {
        var $trs = $(this).parent().parent().find("tr[data-task]");
        var data = getFormData($trs, empId);

        $.ajax({
            type: 'POST',
            data: JSON.stringify(data),
            url: ctx + '/keyWork_evaluate',
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                if(data['result'] == 'Y') {
                    $('#save-modal').modal('show')
                }
            }
        })
    })

    $('a[data-toggle="tab"][data-type="key-work"]').on('show.bs.tab', function (e) {
        $target = $($(e.target).attr('href'))
        $.ajax({
            type: 'POST',
            data: {
                department: $target.data('department')
            },
            url: ctx + '/show_self_evaluate',
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    var task = data[i].task.id
                    var score = data[i].score;
                    var comment = data[i].comment;
                    var finish = data[i].finish;
                    var $tr = $($target.find('tr[data-task="' + task + '"]')[0])
                    $($tr.find('p[data-score]')[0]).html(score)
                    $($tr.find('p[data-comment]')[0]).html(comment)
                    $tr.find('p[data-finish]').html(finish ? '已完成' : '未完成');
                }
            }
        })

        $target.find('input[type="radio"][name^="charge_"]').on('click', function (e) {
            var val = $(this).val()
            $target.find('input[type="radio"][name^="charge_"]').removeProp('checked')
            $target.find('input[type="radio"][name^="charge_"][value="' + val + '"]').prop('checked', 'checked')
        })

        init($target)
    })

    $('a[data-toggle="tab"][data-type="key-work"]').on('hide.bs.tab', function (e) {
        $target.find('input[type="radio"][name^="charge_"]').off('click')
    })

    function init($target) {
        $target.find('td').removeClass('bg-danger')
        $.ajax({
            type: 'POST',
            data: {
                evaluator: empId
            },
            url: ctx + '/show_keyWork_evaluate',
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    var id = data[i].id
                    var task = data[i].task.id
                    var grade = data[i].grade;
                    var level = data[i].level;
                    var charge = data[i].charge;
                    var $tr = $($target.find('tr[data-task="' + task + '"]')[0])
                    $tr.data('id', id)
                    $tr.find('input[name="grade_' + task + '"][value="' + grade + '"]').prop('checked', 'checked');
                    $tr.find('input[name="level_' + task + '"][value="' + level + '"]').prop('checked', 'checked');
                    $tr.find('input[name="charge_' + task + '"][value="' + charge + '"]').prop('checked', 'checked');
                }
            }
        })
    }

    function getFormData($trs, empId) {
        var data = new Array();
        empty = 0;

        for (var i = 0; i < $trs.length; i++) {
            var $tr = $($($trs[i])[0]);
            var task = $tr.data("task")
            var grade = $tr.find('input[name="grade_' + task +'"]:checked').val()
            var level = $tr.find('input[name="level_' + task +'"]:checked').val()
            var charge = $tr.find('input[name="charge_' + task +'"]:checked').val()

            if(grade == null){
                empty++;
                $tr.find('input[name="grade_' + task +'"]').parent().parent().parent().addClass("bg-danger")
            } else {
                $tr.find('input[name="grade_' + task +'"]').parent().parent().parent().removeClass("bg-danger")
            }

            if(level == null) {
                empty++;
                $tr.find('input[name="level_' + task +'"]').parent().parent().parent().addClass("bg-danger")
            } else {
                $tr.find('input[name="level_' + task +'"]').parent().parent().parent().removeClass("bg-danger")
            }

            if(charge == null) {
                empty++;
                $tr.find('input[name="charge_' + task +'"]').parent().parent().parent().addClass("bg-danger")
            } else {
                $tr.find('input[name="charge_' + task +'"]').parent().parent().parent().removeClass("bg-danger")
            }

            var item = {
                id: $tr.data('id'),
                level: level,
                grade: grade,
                charge: charge,
                task: {id: task},
                evaluator: {empId: empId}
            };
            data.push(item);
        }
        return data;
    }
})
