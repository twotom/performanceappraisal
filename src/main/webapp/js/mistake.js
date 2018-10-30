var ctx = $('#ctx').val()
$(function () {
    var $submit_btn = $('.mistake_btn')
    var $save_btn = $('.mistake_save')
    var empId = $('#employee').data('emp')
    var $target;
    var empty = 0;

    $submit_btn.on('click', function (e) {
        var $trs = $(this).parent().parent().find("tr[data-department]");
        var data = getFormData($trs, empId);
        $('#tip-modal').modal('show');

        $('#tip-modal').one('shown.bs.modal', function (e) {
            if(empty == 0) {
                $('#tip-body').html('<p class="bg-success">已填完所有项！</p>')
            } else {
                $('#tip-body').html('<p>还剩<span class="text-danger">' + empty + '</span>项未完成，是否继续提交？</p>')
            }
        })

        $('#confirm').on('click', function (event) {
            $.ajax({
                type: 'POST',
                data: JSON.stringify(data),
                url: ctx + '/irregularPerformances_evaluate',
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
        var $trs = $(this).parent().parent().find("tr[data-department]");
        var data = getFormData($trs, empId);
        $.ajax({
            type: 'POST',
            data: JSON.stringify(data),
            url: ctx + '/irregularPerformances_evaluate',
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                if(data['result'] == 'Y') {
                    $('#save-modal').modal('show')
                }
            }
        })
    })

    $('a[data-toggle="tab"][data-type="mistake"]').on('show.bs.tab', function (e) {
        $target = $($(e.target).attr('href'))
        init($target)

    })

    function init($target) {
        $target.find('td').removeClass('bg-danger')
        $.ajax({
            type: 'POST',
            data: {
                first: 2,
                evaluator: empId,
                second: $target.data('second')
            },
            url: ctx + '/show_irregularPerformances_evaluate',
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    var id = data[i].id
                    var second = data[i].second
                    var score = data[i].score;
                    var comment = data[i].comment;
                    var evidenceFile = data[i].evidenceFile;
                    var department = data[i].department.id;
                    var $tr = $($target.find('tr[data-department="' + department + '"][data-second="' + second + '"]')[0])
                    $tr.data('id', id)
                    $($tr.find('input[name="score"]')[0]).val(score)
                    $($tr.find('textarea[name="comment"]')[0]).val(comment)
                    $($tr.find('input[name="evidenceFile"]')[0]).val(evidenceFile);
                    $($tr.find('p[data-file]')[0]).html(evidenceFile);
                }
            }
        })
    }

    function getFormData($trs, empId) {
        var data = new Array();
        empty = 0;

        for (var i = 0; i < $trs.length; i++) {
            var $tr = $($($trs[i])[0]);
            var department = $tr.data("department")
            var second = $tr.data("second")
            var score = $($tr.find('input[name="score"]')[0]).val()
            var evidenceFile = $($tr.find('input[name="evidenceFile"]')[0]).val()
            var comment = $($tr.find('textarea[name="comment"]')[0]).val()

            if(score.trim() == '') {
                empty++;
                $($tr.find('input[name="score"]')[0]).parent().addClass('bg-danger')
            } else {
                $($tr.find('input[name="score"]')[0]).parent().removeClass('bg-danger')
            }

            if(parseFloat(score) > 0)
                score = 0;

            var item = {
                id: $tr.data('id'),
                first: 2,
                evidenceFile: evidenceFile,
                second: second,
                score: score,
                comment: comment,
                department: {id: department},
                evaluator: {empId: empId},
            };
            data.push(item);
        }
        return data;
    }

    $('button[data-mp]').on('click', function (event) {
        var assessment = ['工作失误', '工作作风', '师德师风', '党风廉政', '审计问题', '安全问题']
        var $box = $('<div><h2 class="print-title">严重失误--' + assessment[$target.data('second') - 1] + '</h2></div>')
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

