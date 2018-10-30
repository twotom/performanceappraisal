var ctx = $('#ctx').val()
$(function () {
    var $submit_btn = $('.contribution_btn')
    var $save_btn = $('.contribution_save')
    var empId = $('#employee').data('emp')
    var $target;
    var empty = 0;

    $submit_btn.on('click', function (e) {
        var $trs = $(this).parent().parent().find("tr[data-department]");
        var data = getFormData($trs, empId);

        $('#tip-modal').modal('show');

        $('#tip-modal').one('shown.bs.modal', function (e) {
            if(empty == 0) {
                $('#tip-body').html('<p class="bg-success">已填完所有项！</p>')
            } else {
                $('#tip-body').html('<p>还剩<span class="text-danger">' + empty + '</span>项未完成，是否继续提交？</p>')
            }
        })

        $('#confirm').on('click', function (event) {
            $.ajax({
                type: 'POST',
                data: JSON.stringify(data),
                url: ctx + '/irregularPerformances_evaluate',
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

    $save_btn.on('click', function (e) {
        var $trs = $(this).parent().parent().find("tr[data-department]");
        var data = getFormData($trs, empId);

        $.ajax({
            type: 'POST',
            data: JSON.stringify(data),
            url: ctx + '/irregularPerformances_evaluate',
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                if(data['result'] == 'Y') {
                    $('#save-modal').modal('show')
                }
            }
        })
    })

    $('a[data-toggle="tab"][data-type="contribution"]').on('show.bs.tab', function (e) {
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
                first: 1,
                evaluator: empId
            },
            url: ctx + '/show_irregularPerformances_evaluate',
            dataType: "json",
            success: function (data) {
                $target.find('.help-block').addClass('hidden')
                for (var i = 0; i < data.length; i++) {
                    var id = data[i].id
                    var second = data[i].second
                    var score = data[i].score;
                    var comment = data[i].comment;
                    var element = data[i].element;
                    var department = data[i].department.id;
                    var $tr = $($target.find('tr[data-department="' + department + '"][data-second="' + second + '"][data-element="' + element + '"]')[0])
                    $tr.data('id', id)
                    $($tr.find('input[name="score"]')[0]).val(score)
                    $($tr.find('textarea[name="comment"]')[0]).val(comment)
                }
            }
        })
    }

    function getFormData($trs, empId) {
        var data = new Array();
        empty = 0;

        for (var i = 0; i < $trs.length; i++) {
            var $tr = $($($trs[i])[0]);
            var department = $tr.data("department")
            var second = $tr.data("second")
            var element = $tr.data("element")
            var score = $($tr.find('input[name="score"]')[0]).val()
            var comment = $($tr.find('textarea[name="comment"]')[0]).val()

            if(score.trim() == '') {
                empty++;
                $($tr.find('input[name="score"]')[0]).addClass('bg-danger')
            } else {
                $($tr.find('input[name="score"]')[0]).removeClass('bg-danger')
            }

            if(parseFloat(score) < 0)
                score = 0;

            var max = parseFloat($($tr.find('input[name="score"]')[0]).data('max'))
            if(parseFloat(score) > max)
                score = max;

            var item = {
                id: $tr.data('id'),
                first: 1,
                element: element,
                second: second,
                score: score,
                comment: comment,
                department: {id: department},
                evaluator: {empId: empId},
            };
            data.push(item);
        }
        return data;
    }
})
