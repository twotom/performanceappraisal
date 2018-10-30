var ctx = $('#ctx').val()
$(function () {
    var empty = 0;

    var $submit_btns = $('.self-submit')
    var $save_btns = $('.self-save')
    var empId = $('#employee').data('emp')
    var $target

    $submit_btns.on('click', function (e) {
        var $trs = $(this).parent().parent().find("tr[data-task]");
        var department = $(this).data('department')
        var data = getFormData($trs, department);

        $('#tip-modal').modal('show');

        $('#tip-modal').one('shown.bs.modal', function (e) {
            if (empty == 0) {
                $('#tip-body').html('<p class="bg-success">已填完所有项！</p>')
            } else {
                $('#tip-body').html('<p>还剩<span class="text-danger">' + empty + '</span>项未完成，是否继续提交？</p>')
            }
        })

        $('#confirm').on('click', function () {
            $.ajax({
                type: 'POST',
                data: JSON.stringify(data),
                url: ctx + '/self_evaluate',
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    if (data['result'] == 'Y') {
                        init($target)
                        $('#tip-modal').modal('hide')
                    }
                }
            })
        })
    })

    $save_btns.on('click', function (e) {
        var $trs = $(this).parent().parent().find("tr[data-task]");
        var department = $(this).data('department')
        var data = getFormData($trs, department);

        $.ajax({
            type: 'POST',
            data: JSON.stringify(data),
            url: ctx + '/self_evaluate',
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                if (data['result'] == 'Y') {
                    $('#save-modal').modal('show')
                }
            }
        })
    })

    $('a[data-toggle="tab"][data-type="self"]').on('show.bs.tab', function (e) {
        e.target // newly activated tab
        e.relatedTarget // previous active tab
        $target = $($(e.target).attr('href'))
        init($target)
    })

    function init($target) {
        $target.find('td').removeClass('bg-danger')

        $.ajax({
            type: 'POST',
            data: {
                department: $target.data('department')
            },
            url: ctx + '/show_self_evaluate',
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    var id = data[i].id
                    var task = data[i].task.id
                    var score = data[i].score;
                    var comment = data[i].comment;
                    var finish = data[i].finish;
                    var $tr = $($target.find('tr[data-task="' + task + '"]')[0])
                    $tr.data('id', id)
                    $($tr.find('input[name="score_' + task + '"]')[0]).val(score)
                    $($tr.find('textarea[name="comment_' + task + '"]')[0]).val(comment)
                    $tr.find('input[name="finish_' + task + '"][value="' + finish + '"]').attr('checked', 'checked');
                }
            }
        })
    }

    function getFormData($trs, department) {
        empty = 0;
        var data = new Array();

        for (var i = 0; i < $trs.length; i++) {
            var $tr = $($($trs[i])[0]);
            var task = $tr.data("task")
            var finish = $tr.find('input[name="finish_' + task + '"]:checked').val()
            var score = $($tr.find('input[name="score_' + task + '"]')[0]).val()
            var comment = $($tr.find('textarea[name="comment_' + task + '"]')[0]).val()

            if (finish == null) {
                empty++;
                $tr.find('input[name="finish_' + task + '"]').parent().parent().parent().addClass("bg-danger")
            } else {
                $tr.find('input[name="finish_' + task + '"]').parent().parent().parent().removeClass("bg-danger")
            }

            if (score.trim() == '') {
                empty++;
                $($tr.find('input[name="score_' + task + '"]')[0]).parent().addClass('bg-danger')
            } else {
                var max = parseFloat($($tr.find('input[name="score_' + task + '"]')[0]).data('max'))
                var min = parseFloat($($tr.find('input[name="score_' + task + '"]')[0]).data('min'))
                var val = parseFloat(score)
                if (val > max)
                    val = max
                if (val < min)
                    val = min

                $($tr.find('input[name="score_' + task + '"]')[0]).parent().removeClass('bg-danger')
            }

            var item = {
                id: $tr.data('id'),
                finish: finish,
                score: score,
                comment: comment,
                department: {id: department},
                task: {id: task},
            };
            data.push(item);
        }
        return data;
    }
})

