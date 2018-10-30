var ctx = $('#ctx').val()
$(function () {
    var empId = $('#employee').data('emp')
    var $target;
    var $submit_btn = $('.regular_btn')
    var $save_btn = $('.regular_save')
    $submit_btn.on('click', function (e) {
        var checkedRadios = $("#regular div.radio input[type='radio']:checked");
        var data = getRadioData(checkedRadios, empId);
        getTip($(this).parent().parent().find('.radio-oneline'))

        $('#tip-modal').modal('show');

        $('#tip-modal').on('shown.bs.modal', function (e) {
            var n = 20 - data.length
            if (n == 0) {
                $('#tip-body').html('<p class="bg-success">已填完所有项！</p>')
            } else {
                $('#tip-body').html('<p>还剩<span class="text-danger">' + n + '</span>项未完成，是否继续提交？</p>')
            }
        })

        $('#confirm').click(function () {
            $.ajax({
                type: 'POST',
                data: JSON.stringify(data),
                url: ctx + '/regular_evaluate',
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
        var checkedRadios = $("#regular div.radio input[type='radio']:checked");
        var data = getRadioData(checkedRadios, empId);
        getTip($(this).parent().parent().find('.radio-oneline'))

        $.ajax({
            type: 'POST',
            data: JSON.stringify(data),
            url: ctx + '/regular_evaluate',
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                if(data['result'] == 'Y') {
                    $('#save-modal').modal('show')
                }
            }
        })
    })

    $('a[data-toggle="tab"][data-type="regular"]').on('show.bs.tab', function (e) {
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
                evaluator: empId,
            },
            url: ctx + '/show_regular_evaluate',
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    var id = data[i].id;
                    var choose = data[i].choose;
                    var department = data[i].department.id;
                    $target.find('input[type="radio"][name="' + department + '"][value="' + choose + '"]').attr('checked', 'checked');
                    $target.find('input[type="radio"][name="' + department + '"]').data('id', id);

                }
            }
        })
    }

    function getRadioData(objs, empId) {
        var data = new Array();

        for (var i = 0; i < objs.length; i++) {
            var radio = $(objs[i]);
            var item = {
                id: radio.data('id'),
                choose: radio.val(),
                evaluator: {empId: empId},
                department: {id: radio.attr('name')},
            };
            data.push(item);
        }
        return data;
    }

    function getTip(objs) {
        for (var i = 0; i < objs.length; i++) {
            if($(objs[i]).find('input[type="radio"]:checked').length == 0) {
                $(objs[i]).addClass('bg-danger')
            } else {
                $(objs[i]).removeClass('bg-danger')
            }
        }
    }
})
