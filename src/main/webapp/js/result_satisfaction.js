var ctx = $('#ctx').val()
$(function () {
    $('a[data-toggle="tab"][data-type="result_satisfaction"]').on('show.bs.tab', function (e) {
        var $target = $('#result-box')

        $.ajax({
            type: 'POST',
            url: ctx + '/result_satisfaction',
            dataType: "json",
            success: function (data) {
                $target.empty()
                for (var department in data) {
                    var $item = $('<tr>' +
                        '<td>' + department + '</td>>' +
                        '<td>' + data[department][0].toFixed(2) + '</td>' +
                        '<td>' + data[department][1].toFixed(2) + '</td>' +
                        '<td>' + data[department][2].toFixed(2) + '</td>' +
                        '</tr>')
                    $target.append($item)
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