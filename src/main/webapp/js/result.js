var ctx = $('#ctx').val()
$(function () {
    $('a[data-toggle="tab"][data-type="result"]').on('show.bs.tab', function (e) {
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
            url: ctx + '/result_show',
            dataType: "json",
            success: function (data) {
                $target.empty()
                for (var department in departments) {
                    var $item = $('<tr>' +
                        '<td>' + department + '</td>>' +
                        '<td>' + ((parseFloat(data[department][9]))).toFixed(2) + '</td>' +
                        '<td>' + (parseFloat(data[department][0].toFixed(2)) + parseFloat(data[department][1].toFixed(2)) + parseFloat(data[department][2].toFixed(2)) + parseFloat(data[department][3].toFixed(2)) + parseFloat(data[department][4].toFixed(2))).toFixed(2) + '</td>' +
                        '<td>' + (parseFloat(data[department][0].toFixed(2)) + parseFloat(data[department][1].toFixed(2))).toFixed(2) + '</td>' +
                        '<td><a href="#detail" data-toggle="modal" data-department="' + departments[department] + '"  data-shortName="' + department + '" data-type="1">' + data[department][0].toFixed(2) + '</a></td>' +
                        '<td><a href="#detail" data-toggle="modal" data-department="' + departments[department] + '"  data-shortName="' + department + '" data-type="2">' + data[department][1].toFixed(2) + '</a></td>' +
                        '<td>' + (parseFloat(data[department][2].toFixed(2)) + parseFloat(data[department][3].toFixed(2)) + parseFloat(data[department][4].toFixed(2))).toFixed(2) + '</td>' +
                        '<td>' + data[department][2].toFixed(2) + '</td>' +
                        '<td>' + data[department][3].toFixed(2) + '</td>' +
                        '<td>' + data[department][4].toFixed(2) + '</td>' +
                        '<td>' + (parseFloat(data[department][5].toFixed(2)) + parseFloat(data[department][6].toFixed(2))).toFixed(2) + '</td>' +
                        '<td><a href="#detail" data-toggle="modal" data-department="' + departments[department] + '"  data-shortName="' + department + '" data-type="3" data-indicator="1">' + data[department][5].toFixed(2) + '</a></td>' +
                        '<td><a href="#detail" data-toggle="modal" data-department="' + departments[department] + '"  data-shortName="' + department + '" data-type="3" data-indicator="2">' + data[department][6].toFixed(2) + '</a></td>' +
                        '<td>' + (parseFloat(data[department][7].toFixed(2)) + parseFloat(data[department][8].toFixed(2))).toFixed(2) + '</td>' +
                        '<td><a href="#detail" data-toggle="modal" data-department="' + departments[department] + '"  data-shortName="' + department + '" data-type="4" data-first="1">' + data[department][7].toFixed(2) + '</a></td>' +
                        '<td><a href="#detail" data-toggle="modal" data-department="' + departments[department] + '"  data-shortName="' + department + '" data-type="4" data-first="2">' + data[department][8].toFixed(2) + '</a></td>' +
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

    $('#detail').on('shown.bs.modal', function (e) {
        var $relatedTarget = $(e.relatedTarget)
        var type = $relatedTarget.data('type')
        var department = $relatedTarget.data('department')
        var shortName = $relatedTarget.data('shortname')

        switch (type) {
            case 1:
                regular_detail(department, shortName);
                break;
            case 2:
                keywork_detail(department, shortName);
                break;
            case 3:
                routine_detail(department, shortName, $relatedTarget.data('indicator'));
                break;
            case 4:
                irregular_detail(department, shortName, $relatedTarget.data('first'));
                break;
        }
    })

    $('#detail').on('hidden.bs.modal', function (e) {
        $('#detail-body').empty()
    })

    function regular_detail(department, shortName) {
        $.ajax({
            type: 'POST',
            url: ctx + '/detail_regular',
            data: {
                department: department
            },
            dataType: "json",
            success: function (data) {
                var people = ['王丹中', '周勇', '费云生', '眭碧霞', '陈刚', '费小平', '孙荣明']

                var $table = $('<table class="table table-striped table-hover table-bordered"><thead><tr><th colspan="2">' + shortName + '常规工作得分</th></tr><tr><th>赋分人</th><th>评分</th></tr></thead></table>')
                var $tbody = $('<tbody></tbody>')
                for (var item in people) {
                    $tbody.append($('<tr><td>' + people[item] + '</td><td>' + (data[people[item]] ? parseFloat(data[people[item]]).toFixed(2) : '未评分') + '</td></tr>'))
                }
                $table.append($tbody)
                $('#detail-body').empty().append($table)
            }
        })
    }

    function keywork_detail(department, shortName) {
        $.ajax({
            type: 'POST',
            url: ctx + '/detail_keywork',
            data: {
                department: department
            },
            dataType: "json",
            success: function (data) {
                var people = ['王丹中', '周勇', '费云生', '眭碧霞', '陈刚', '费小平', '孙荣明', '宋卫', '周敏', '薛苏云', '陈必群', '陈黎敏']

                var $table = $('<table class="table table-striped table-hover table-bordered"><thead><tr><th colspan="2">' + shortName + '重点工作得分</th></tr><tr><th>赋分人</th><th>评分</th></tr></thead></table>')
                var $tbody = $('<tbody></tbody>')
                for (var item in people) {
                    $tbody.append($('<tr><td>' + people[item] + '</td><td>' + (data[people[item]] ? parseFloat(data[people[item]]).toFixed(2) : '未评分') + '</td></tr>'))
                }
                $table.append($tbody)
                $('#detail-body').empty().append($table)
            }
        })
    }

    function routine_detail(department, shortName, indicator) {
        $.ajax({
            type: 'POST',
            url: ctx + '/detail_routine',
            data: {
                department: department,
                indicator: indicator
            },
            dataType: "json",
            success: function (data) {
                var assessments = [{
                    '宣传思想政治工作': ['宣传部', 1],
                    '队伍建设': ['人力资源部', 1],
                    '廉政建设': ['纪委办', 2],
                    '制度建设': ['发展规划处', 1.5]
                }, {
                    '工作计划和总结报送的及时性': ['党办院办', 1],
                    '工作台账规范性资料上交或部门归档': ['考核小组', 2],
                    '安全保卫': ['保卫处', 2.5],
                    '资产设备保管环境卫生': ['资后处', 2.5],
                    '经费预决算及规范使用': ['财务处', 2]
                }]

                var $table = $('<table class="table table-striped table-hover table-bordered"><thead><tr><td colspan="4">' + shortName + (indicator == 1 ? '作风建设得分' : '工作条理性得分') + '</td></tr><tr><th>考核项</th><th>赋分主体</th><th>评分</th><th>满分</th></tr></thead></table>')
                var $tbody = $('<tbody></tbody>')
                for (var item in assessments[indicator - 1]) {
                    $tbody.append($('<tr><td>' + item + '</td><td>' + assessments[indicator - 1][item][0] + '</td><td>' + (data[item] ? parseFloat(data[item]).toFixed(2) : '未评分') + '</td><td>' + assessments[indicator - 1][item][1] + '</td></tr>'))
                }
                $table.append($tbody)
                $('#detail-body').empty().append($table)
            }
        })
    }

    function irregular_detail(department, shortName, first) {
        $.ajax({
            type: 'POST',
            url: ctx + '/detail_irregular',
            data: {
                department: department,
                first: first
            },
            dataType: "json",
            success: function (data) {
                var assessments = [{
                    '重大贡献': ['考核小组', 10],
                    '奖励表彰': ['考核小组', 10]
                }, {
                    '工作失误': ['党办院办', -10],
                    '工作作风': ['考核小组', -10],
                    '师德师风': ['人力资源', -10],
                    '党风廉政': ['纪委办', -10],
                    '审计问题': ['审计处', -10],
                    '安全工作': ['保卫处', -10]
                }]

                var $table = $('<table class="table table-striped table-hover table-bordered"><thead><tr><th colspan="4">' + shortName + (first == 1 ? '突出贡献得分' : '严重失误得分')  + '</th></tr><tr><th>考核项</th><th>赋分主体</th><th>评分</th><th>满分</th></tr></thead></table>')
                var $tbody = $('<tbody></tbody>')
                for (var item in assessments[first - 1]) {
                    $tbody.append($('<tr><td>' + item + '</td><td>' + assessments[first - 1][item][0] + '</td><td>' + (data[item] ? parseFloat(data[item]).toFixed(2) : '未评分') + '</td><td>' + assessments[first - 1][item][1] + '</td></tr>'))
                }
                $table.append($tbody)
                $('#detail-body').empty().append($table)
            }
        })
    }
})