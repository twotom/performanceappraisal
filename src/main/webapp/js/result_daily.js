var ctx = $('#ctx').val()
$(function () {
    $('a[data-toggle="tab"][data-type="result_daily"]').on('show.bs.tab', function (e) {
        var $target = $('#result-box')
        var type = $(this).data('item')

        $.ajax({
            type: 'POST',
            url: ctx + '/result_daily',
            data: {
                type: type,
            },
            dataType: "json",
            success: function (data) {
                for(var routine in data) {
                    var $tr = $target.find('tr[data-department="' + data[routine]['department']['id'] + '"][data-indicator="' + data[routine]['indicator'] + '"]')
                    $tr.find('td[data-element="' + data[routine]['element'] + '"]').html(parseFloat(data[routine]['score']))
                }
            }
        })
    })

    $('#print-preview').click(function (event) {
        $('#print').print({
            timeout: 333,
            title: "常州信息职业技术学院绩效考核考核结果",
            mediaPrint: true
        })
    })
})