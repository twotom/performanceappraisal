$(function () {
    var ctx = $('#ctx').val()

    $('.form_datetime').datetimepicker({
        language: 'zh-CN',
        format: "yyyy-mm-dd HH:ii:ss",
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });

    $('#submit').on('click', function (e) {
        var time = $('#time').val()

        if(time.trim() == '') {
            $('#tip-body').empty().append($('<p class="text-danger text-center">请选择时间</p>'))
            $('#tip').modal('show')

            return
        }

        time = new Date(time)
        $.ajax({
            type: 'POST',
            data: {
                time: time.getTime()
            },
            url: ctx + '/setTime',
            success: function (data) {
                if (data == 'Y') {
                    $('#tip-body').empty().append($('<p class="text-success text-center">设定成功！</p>'))
                    $('#tip').modal('show')
                }
            }
        })
    })
})