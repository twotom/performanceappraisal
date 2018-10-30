var ctx = $('#ctx').val()
$(function () {
    $('a[data-toggle="tab"][data-type="result"]').on('show.bs.tab', function (e) {
        var $target = $('#result-box')
        $.ajax({
            type: 'POST',
            url: ctx + '/result_department_show',
            data: {
                department: $target.data('department')
            },
            dataType: "json",
            success: function (data) {
                $target.empty()
                var sum = 0.0;
                var all = ["关键绩效-常规工作", "关键绩效-重点工作", "关键绩效-上级评价", "关键绩效-服务对象", "关键绩效-同级部门", "日常绩效-作风建设", "日常绩效-工作条理", "例外绩效-突出贡献", "例外绩效-严重失误"]
                var assessment = ['日常绩效-作风建设', '日常绩效-工作条理', '例外绩效-突出贡献', '例外绩效-严重失误']
                for (var i in all) {
                    var item = all[i]
                    var $item = $('<tr><td>' + item + '</td></tr>')
                    if(assessment.indexOf(item) != -1) {
                        var index = assessment.indexOf(item)
                        var type = parseInt(index / 2);
                        var indicator = index % 2 + 1;
                        var $td = $('<td><a href="#detail" data-toggle="modal" data-department="' + $target.data('department') + '" data-type="' + type + '" data-indicator="' + indicator + '">' + parseFloat(data[item].toFixed(2)) + '</a></td>')
                        $item.append($td)
                    } else {
                        var $td = $('<td>' + parseFloat(data[item].toFixed(2)) + '</td>')
                        $item.append($td)
                    }
                    $target.append($item)
                    sum += parseFloat(data[item])
                }
                $target.append($('<tr>' +
                '<td>总分</td>' +
                '<td>' + sum.toFixed(2) + '</td>' +
                '</tr>'))
            }
        })
    })

    $('#detail').on('shown.bs.modal', function (e) {
        var $relatedTarget = $(e.relatedTarget)
        var type = $relatedTarget.data('type')
        var department = $relatedTarget.data('department')

        switch (type) {
            case 0:
                routine_detail(department, $relatedTarget.data('indicator'));
                break;
            case 1:
                irregular_detail(department, $relatedTarget.data('indicator'));
                break;
        }
    })

    function routine_detail(department, indicator) {
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

                var $table = $('<table class="table table-striped table-hover table-bordered"><thead><tr><th>考核项</th><th>赋分主体</th><th>评分</th><th>满分</th></tr></thead></table>')
                var $tbody = $('<tbody></tbody>')
                for (var item in assessments[indicator - 1]) {
                    $tbody.append($('<tr><td>' + item + '</td><td>' + assessments[indicator - 1][item][0] + '</td><td>' + (data[item] ? parseFloat(data[item]).toFixed(2) : '未评分') + '</td><td>' + assessments[indicator - 1][item][1] + '</td></tr>'))
                }
                $table.append($tbody)
                $('#detail-body').empty().append($table)
            }
        })
    }

    function irregular_detail(department, first) {
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

                var $table = $('<table class="table table-striped table-hover table-bordered"><thead><tr><th>考核项</th><th>赋分主体</th><th>评分</th><th>满分</th></tr></thead></table>')
                var $tbody = $('<tbody></tbody>')
                for (var item in assessments[first - 1]) {
                    $tbody.append($('<tr><td>' + item + '</td><td>' + assessments[first - 1][item][0] + '</td><td>' + (data[item] ? parseFloat(data[item]).toFixed(2) : '未评分') + '</td><td>' + assessments[first - 1][item][1] + '</td></tr>'))
                }
                $table.append($tbody)
                $('#detail-body').empty().append($table)
            }
        })
    }

    $('#detail').on('hidden.bs.modal', function (e) {
        $('#detail-body').empty()
    })

    $('#print-preview').click(function (event) {
        $('#print').print({
            timeout: 333,
            title: "常州信息职业技术学院绩效考核考核结果",
            mediaPrint: true
        })
    })

})