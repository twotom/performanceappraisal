$(function () {
    var ctx = $('#ctx').val()

    var $submit_btns = $('.satisfaction_btn')
    var $save_btns = $('.satisfaction_save')
    var empId = $('#employee').data('emp')
    var $target;

    $submit_btns.on('click', function (e) {
        var checkedRadios = $(this).parent().parent().find("div.radio input[type='radio']:checked");
        var indicator = $(this).data('indicator')
        var data = getRadioData(checkedRadios, empId, indicator);
        getTip($(this).parent().parent().find('.radio-oneline'))
        var empty = $(this).parent().parent().find('tbody tr').length - data.length

        $('#tip-modal').modal('show');

        $('#tip-modal').one('shown.bs.modal', function (e) {
            if (empty == 0) {
                $('#tip-body').html('<p class="bg-success">已填完所有项！</p>')
            } else {
                $('#tip-body').html('<p>还剩<span class="text-danger">' + empty + '</span>项未完成，是否继续提交？</p>')
            }
        })

        if(empty == 0) {
            $('#confirm').removeAttr("disabled")
        } else {
            $('#confirm').attr("disabled", true)
        }

        $('#confirm').on('click', function (event) {
            $.ajax({
                type: 'POST',
                data: JSON.stringify(data),
                url: ctx + '/satisfaction_evaluate',
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
        var checkedRadios = $(this).parent().parent().find("div.radio input[type='radio']:checked");
        var indicator = $(this).data('indicator')
        var data = getRadioData(checkedRadios, empId, indicator);
        getTip($(this).parent().parent().find('.radio-oneline'))

        $.ajax({
            type: 'POST',
            data: JSON.stringify(data),
            url: ctx + '/satisfaction_evaluate',
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                if (data['result'] == 'Y') {
                    $('#save-modal').modal('show')
                }
            }
        })
    })

    $target = $('#satisfaction')
    init($target)

    function init($target) {
        $target.find('td').removeClass('bg-danger')
        $.ajax({
            type: 'POST',
            data: {
                evaluator: empId,
                indicator: $target.data('indicator')
            },
            url: ctx + '/show_satisfaction_evaluate',
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    var id = data[i].id;
                    var element = data[i].element;
                    var choose = data[i].choose;
                    var department = data[i].department.id;
                    $target.find('input[type="radio"][name="' + department + '_' + element + '"][value="' + choose + '"]').attr('checked', 'checked');
                    $target.find('input[type="radio"][name="' + department + '_' + element + '"]').data('id', id);
                }
            }
        })
    }

    function getRadioData(objs, empId, indicator) {
        var data = new Array();

        for (var i = 0; i < objs.length; i++) {
            var radio = $(objs[i]);
            var name = radio.attr('name').split('_')

            var item = {
                id: radio.data('id'),
                indicator: indicator,
                element: name[1],
                choose: radio.val(),
                evaluator: {empId: empId},
                department: {id: name[0]},
            };
            data.push(item);
        }
        return data;
    }

    function getTip(objs) {
        for (var i = 0; i < objs.length; i++) {
            if ($(objs[i]).find('input[type="radio"]:checked').length == 0) {
                $(objs[i]).addClass('bg-danger')
            } else {
                $(objs[i]).removeClass('bg-danger')
            }
        }
    }
})
