var ctx = $('#ctx').val()
$(function () {
    $('a[data-toggle="tab"][data-type="result_key"]').on('show.bs.tab', function (e) {
        var $target = $('#result-box')
        var departments = {
            "党办院办": 201,
            "纪委办": 202,
            "组织部": 203,
            "宣传部": 204,
            "学生工作部": 205,
            "保卫部": 206,
            "团委": 207,
            "工会": 208,
            "人力资源处": 209,
            "教务处": 210,
            "质监部": 211,
            "招生处": 212,
            "产学合作部": 213,
            "科技处": 214,
            "发展规划处": 215,
            "财务处": 216,
            "审计处": 217,
            "资后处": 218,
            "图书馆": 219,
            "信息中心": 220,
        }
        $.ajax({
            type: 'POST',
            url: ctx + '/result_key',
            dataType: "json",
            success: function (data) {
                $target.empty()
                for (var department in departments) {
                    var $item = $('<tr>' +
                        '<td>' + department + '</td>>' +
                        '<td>' + data[department][0].toFixed(2) + '</td>' +
                        '<td>' + data[department][1].toFixed(2) + '</td>' +
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