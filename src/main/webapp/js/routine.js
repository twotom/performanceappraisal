var ctx = $('#ctx').val()
$(function () {
    var $submit_btns = $('.routine_btn')
    var $save_btns = $('.routine_save')
    var empId = $('#employee').data('emp')
    var $target;
    var empty = 0;

    $submit_btns.on('click', function (e) {
        var $trs = $(this).parent().parent().find("tr[data-department]");
        var indicator = $(this).data('indicator')
        var element = $(this).data('element')
        var data = getFormData($trs, empId, indicator, element);

        $('#tip-modal').modal('show');

        $('#tip-modal').one('shown.bs.modal', function (event) {
            if (empty == 0) {
                $('#tip-body').html('<p class="bg-success">已填完所有项！</p>')
            } else {
                $('#tip-body').html('<p>还剩<span class="text-danger">' + empty + '</span>项未完成，是否继续提交？</p>')
            }
        })

        $('#confirm').on('click', function () {
            $.ajax({
                type: 'POST',
                data: JSON.stringify(data),
                url: ctx + '/routine_evaluate',
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
        var $trs = $(this).parent().parent().find("tr[data-department]");
        var indicator = $(this).data('indicator')
        var element = $(this).data('element')
        var data = getFormData($trs, empId, indicator, element);

        $.ajax({
            type: 'POST',
            data: JSON.stringify(data),
            url: ctx + '/routine_evaluate',
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                if (data['result'] == 'Y') {
                    $('#save-modal').modal('show')
                }
            }
        })
    })

    $('a[data-toggle="tab"][data-type="routine"]').on('show.bs.tab', function (e) {
        $target = $($(e.target).attr('href'))
        init($target)

    })

    function init($target) {
        $target.find('td').removeClass('bg-danger')
        $.ajax({
            type: 'POST',
            data: {
                evaluator: empId,
                indicator: $target.data('indicator'),
                element: $target.data('element')
            },
            url: ctx + '/show_routine_evaluate',
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    var id = data[i].id;
                    var department = data[i].department.id;
                    var score = data[i].score;
                    var comment = data[i].comment;
                    var evidenceFile = data[i].evidenceFile
                    var $tr = $($target.find('tr[data-department="' + department + '"]')[0])
                    $tr.data('id', id)
                    $($tr.find('input[name="score"]')[0]).val(score)
                    $($tr.find('textarea[name="comment"]')[0]).val(comment)
                    $($tr.find('input[name="evidenceFile"]')[0]).val(evidenceFile)
                    $($tr.find('p[data-file]')[0]).html(evidenceFile)
                }
            }
        })

        $target.find('.help-block').addClass('hidden')
    }

    function getFormData($trs, empId, indicator, element) {
        var data = new Array();
        empty = 0;
        for (var i = 0; i < $trs.length; i++) {
            var $tr = $($($trs[i])[0]);
            var department = $tr.data('department')
            var score = $($tr.find('input[name="score"]')[0]).val()
            var comment = $($tr.find('textarea[name="comment"]')[0]).val()
            var evidenceFile = $($tr.find('input[name="evidenceFile"]')[0]).val()
            if (score.trim() == '') {
                empty++;
                $($tr.find('input[name="score"]')[0]).parent().addClass('bg-danger')
            } else {
                $($tr.find('input[name="score"]')[0]).parent().removeClass('bg-danger')

                var max = parseFloat($($tr.find('input[name="score"]')[0]).data('max'))
                var min = parseFloat($($tr.find('input[name="score"]')[0]).data('min'))
                score = parseFloat(score)
                if (score > max) {
                    score = max
                }
                if (score < min) {
                    score = min
                }
            }

            var item = {
                id: $tr.data('id'),
                indicator: indicator,
                element: element,
                score: score,
                comment: comment,
                evidenceFile: evidenceFile,
                evaluator: {empId: empId},
                department: {id: department},
            };
            data.push(item);
        }
        return data;
    }

    $('button[data-preview]').on('click', function (event) {
        var first = ['作风建设', '工作条理性']
        var assessment = [['宣传思想政治工作', '队伍建设', '廉政建设', '制度建设'], ['工作计划和总结报送的及时性', '工作台账规范性资料上交或部门归档', '安全保卫', '资料设备保管环境卫生', '经费预决算及规范使用']]
        var $box = $('<div><h2 class="print-title">' + first[$target.data('indicator') - 1] + '--' + assessment[$target.data('indicator') - 1][$target.data('element') - 1] + '</h2></div>')
        var $table = $('<table class="table table-striped table-hover table-bordered"><thead><tr><th>职能部门</th><th>分值</th><th>说明</th><th>佐证材料</th></tr></thead></table>')
        var $tbody = $('<tbody></tbody>')
        $tbody.append(getPrintData($target.find("tr[data-department]")))
        $table.append($tbody)
        $box.append($table)

        $box.print({
            timeout: 333,
            mediaPrint: true
        })
    })

    function getPrintData($trs) {
        var data = new Array();
        for (var i = 0; i < $trs.length; i++) {
            var $tr = $($($trs[i])[0]);
            var department = $tr.find('td:first').html()
            var score = $($tr.find('input[name="score"]')[0]).val()
            var comment = $($tr.find('textarea[name="comment"]')[0]).val()
            var evidenceFile = $($tr.find('input[name="evidenceFile"]')[0]).val()

            var item = $('<tr><td>' + department + '</td><td>' + score + '</td><td>' + comment + '</td><td>' + evidenceFile + '</td></tr>')
            data.push(item);
        }
        return data;
    }
})

