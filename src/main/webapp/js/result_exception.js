var ctx = $('#ctx').val()
$(function () {
    $('a[data-toggle="tab"][data-type="result_exception"]').on('show.bs.tab', function (e) {
        var $target = $('#exception-box')

        $.ajax({
            type: 'POST',
            url: ctx + '/result_exception',
            dataType: "json",
            success: function (data) {
                for (var index in data) {
                    var $tr = $target.find('tr[data-department="' + data[index]['department']['id'] + '"]')
                    $tr.find('td[data-first="' + data[index]['first'] + '"][data-second="' + data[index]['second'] + '"]').html(parseFloat(data[index]['score']))
                }
            }
        })
    })

    $('#exception-preview').click(function (event) {
        $('#exception-print').print({
            timeout: 333,
            title: "常州信息职业技术学院绩效考核考核结果",
            mediaPrint: true
        })
    })
})