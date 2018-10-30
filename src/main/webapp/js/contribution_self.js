var ctx = $('#ctx').val()
$(function () {
    var $submit_btn = $('.contribution_self_btn')
    var $save_btn = $('.contribution_self_save')
    var empId = $('#employee').data('emp')

    $submit_btn.on('click', function (e) {
        var department = $(this).data('department');
        var $trs = $(this).parent().parent().find("tr[data-indicator]");
        var data = getFormData($trs, department);

        $('#tip-modal').modal('show');

        $('#tip-modal').one('shown.bs.modal', function (e) {
            $('#tip-body').html('<p>已填写<span class="text-danger">' + data.length + '</span>项，是否继续提交？</p>')
        })

        $('#confirm').on('click', function () {
            $.ajax({
                type: 'POST',
                data: JSON.stringify(data),
                url: ctx + '/contribution_evaluate',
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    if (data['result'] == 'Y') {
                        var $target = $('#contribution-content')
                        init($target, $target.data('department'))
                        $('#tip-modal').modal('hide')
                    }
                }
            })

        })
    })

    $save_btn.on('click', function (e) {
        var department = $(this).data('department');
        var $trs = $(this).parent().parent().find("tr[data-indicator]");
        var data = getFormData($trs, department);

        $.ajax({
            type: 'POST',
            data: JSON.stringify(data),
            url: ctx + '/contribution_evaluate',
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                if (data['result'] == 'Y') {
                    $('#save-modal').modal('show')
                }
            }
        })
    })

    $('a[data-toggle="tab"][data-type="contribution_self"]').on('show.bs.tab', function (e) {
        var $target = $('#contribution-content')
        init($target, $target.data('department'))
    })

    function init($target, department) {
        $target.find('td').removeClass('bg-danger')

        $.ajax({
            type: 'POST',
            data: {
                department: department
            },
            url: ctx + '/show_contribution_evaluate',
            dataType: "json",
            success: function (data) {
                $target.html('')
                if (data['contributions'].length == 0) {
                    var $contributions = $('<tr data-indicator="1">\n' +
                        '                    <td rowspan="3" class="rowspan" id="contribution-description">重大贡献</td>\n' +
                        '                    <td class="exclusion">\n' +
                        '                        <input type="text" class="form-control" name="score" data-validate data-max="100" data-min="0">\n' +
                        '                    </td>\n' +
                        '                    <td>\n' +
                        '                        <textarea class="form-control" name="comment"></textarea>\n' +
                        '                    </td>\n' +
                        '                    <td>\n' +
                        '                        <p data-file></p>\n' +
                        '                    </td>' +
                        '                    <td>\n' +
                        '                        <input type="hidden" name="evidenceFile">\n' +
                        '                        <button class="btn btn-block btn-primary" data-target="#upload-modal" data-toggle="modal" type="button">上传文件</button>\n' +
                        '                    </td>\n' +
                        '                    <td>\n' +
                        '                        <a href="javascript:void(0);" class="delete-item" data-description="#contribution-description">删除</a>\n' +
                        '                    </td>\n' +
                        '                </tr>\n' +
                        '                <tr data-indicator="1">\n' +
                        '                    <td class="exclusion">\n' +
                        '                        <input type="text" class="form-control" name="score" data-validate data-max="100" data-min="0">\n' +
                        '                    </td>\n' +
                        '                    <td>\n' +
                        '                        <textarea class="form-control" name="comment"></textarea>\n' +
                        '                    </td>\n' +
                        '                    <td>\n' +
                        '                        <p data-file></p>\n' +
                        '                    </td>' +
                        '                    <td>\n' +
                        '                        <input type="hidden" name="evidenceFile">\n' +
                        '                        <button class="btn btn-block btn-primary" data-target="#upload-modal" data-toggle="modal" type="button">上传文件</button>\n' +
                        '                    </td>\n' +
                        '                    <td>\n' +
                        '                        <a href="javascript:void(0);" class="delete-item" data-description="#contribution-description">删除</a>\n' +
                        '                    </td>\n' +
                        '                </tr>\n' +
                        '                <tr>\n' +
                        '                    <td colspan="5" class="text-center">\n' +
                        '                        <a href="javascript:void(0);" class="add-item" data-description="#contribution-description" data-indicator="1">添加新项</a>\n' +
                        '                    </td>\n' +
                        '                </tr>')
                    $target.append($contributions)
                } else {
                    for (var index in data['contributions']) {
                        var $item = $('<tr data-indicator="1" data-id="' + data['contributions'][index].id + '">\n' +
                            '                        <td class="exclusion">\n' +
                            '                            <input type="text" class="form-control" name="score" value="' + (data['contributions'][index].score ? data['contributions'][index].score : '') + '"  data-validate data-max="100" data-min="0">\n' +
                            '                        </td>\n' +
                            '                        <td>\n' +
                            '                            <textarea class="form-control" name="comment">' + data['contributions'][index].comment + '</textarea>\n' +
                            '                        </td>\n' +
                            '                        <td>\n' +
                            '                           <p data-file>' + data['contributions'][index].evidenceFile + '</p>\n' +
                            '                        </td>' +
                            '                        <td>\n' +
                            '                            <input type="hidden" name="evidenceFile" value="' + data['contributions'][index].evidenceFile + '">\n' +
                            '                            <button class="btn btn-block btn-primary" data-target="#upload-modal" data-toggle="modal" type="button">上传文件</button>\n' +
                            '                        </td>\n' +
                            '                        <td>\n' +
                            '                            <a href="javascript:void(0);" class="delete-item" data-description="#contribution-description">删除</a>\n' +
                            '                        </td>\n' +
                            '                    </tr>')
                        if (index == 0) {
                            $item.prepend($('<td rowspan="' + (parseInt(data['contributions'].length) + 1) + '" class="rowspan" id="contribution-description">重大贡献</td>'))
                        }
                        $target.append($item)
                    }
                    $target.append($('<tr>\n' +
                        '                    <td colspan="5" class="text-center">\n' +
                        '                        <a href="javascript:void(0);" class="add-item" data-description="#contribution-description" data-indicator="1">添加新项</a>\n' +
                        '                    </td>\n' +
                        '                </tr>'))

                }

                if (data['commendations'].length == 0) {
                    var $commendations = $('<tr data-indicator="2">\n' +
                        '                    <td rowspan="3" class="rowspan" id="commendation-description">奖励表彰</td>\n' +
                        '                    <td class="exclusion">\n' +
                        '                        <input type="text" class="form-control" name="score" data-validate data-max="100" data-min="0">\n' +
                        '                    </td>\n' +
                        '                    <td>\n' +
                        '                        <textarea class="form-control" name="comment"></textarea>\n' +
                        '                    </td>\n' +
                        '                    <td>\n' +
                        '                        <p data-file></p>\n' +
                        '                    </td>' +
                        '                    <td>\n' +
                        '                        <input type="hidden" name="evidenceFile">\n' +
                        '                        <button class="btn btn-block btn-primary" data-target="#upload-modal" data-toggle="modal" type="button">上传文件</button>\n' +
                        '                    </td>\n' +
                        '                    <td>\n' +
                        '                        <a href="javascript:void(0);" class="delete-item" data-description="#commendation-description">删除</a>\n' +
                        '                    </td>\n' +
                        '                </tr>\n' +
                        '                <tr data-indicator="2">\n' +
                        '                    <td class="exclusion">\n' +
                        '                        <input type="text" class="form-control" name="score" data-validate data-max="100" data-min="0">\n' +
                        '                    </td>\n' +
                        '                    <td>\n' +
                        '                        <textarea class="form-control" name="comment"></textarea>\n' +
                        '                    </td>\n' +
                        '                    <td>\n' +
                        '                        <p data-file></p>\n' +
                        '                    </td>' +
                        '                    <td>\n' +
                        '                        <input type="hidden" name="evidenceFile">\n' +
                        '                        <button class="btn btn-block btn-primary" data-target="#upload-modal" data-toggle="modal" type="button">上传文件</button>\n' +
                        '                    </td>\n' +
                        '                    <td>\n' +
                        '                        <a href="javascript:void(0);" class="delete-item" data-description="#commendation-description">删除</a>\n' +
                        '                    </td>\n' +
                        '                </tr>\n' +
                        '                <tr>\n' +
                        '                    <td colspan="5" class="text-center">\n' +
                        '                        <a href="javascript:void(0);" class="add-item" data-description="#commendation-description" data-indicator="2">添加新项</a>\n' +
                        '                    </td>\n' +
                        '                </tr>')
                    $target.append($commendations)
                } else {
                    for (var index in data['commendations']) {
                        var $item = $('<tr data-indicator="2" data-id="' + data['commendations'][index].id + '">\n' +
                            '                        <td class="exclusion">\n' +
                            '                            <input type="text" class="form-control" name="score" value="' + (data['commendations'][index].score ? data['commendations'][index].score : '') + '" data-validate data-max="100" data-min="0">\n' +
                            '                        </td>\n' +
                            '                        <td>\n' +
                            '                                <textarea class="form-control" name="comment">' + data['commendations'][index].comment + '</textarea>\n' +
                            '                        </td>\n' +
                            '                        <td>\n' +
                            '                                <p data-file>' + data['commendations'][index].evidenceFile + '</p>\n' +
                            '                        </td>' +
                            '                        <td>\n' +
                            '                            <input type="hidden" name="evidenceFile" value="' + data['commendations'][index].evidenceFile + '">\n' +
                            '                            <button class="btn btn-block btn-primary" data-target="#upload-modal" data-toggle="modal" type="button">上传文件</button>\n' +
                            '                        </td>\n' +
                            '                        <td>\n' +
                            '                            <a href="javascript:void(0);" class="delete-item" data-description="#commendation-description">删除</a>\n' +
                            '                        </td>\n' +
                            '                    </tr>')
                        if (index == 0) {
                            $item.prepend($('<td rowspan="' + (parseInt(data['commendations'].length) + 1) + '" class="rowspan" id="commendation-description">奖励表彰</td>'))
                        }
                        $target.append($item)
                    }

                    $target.append($('<tr>\n' +
                        '                    <td colspan="5" class="text-center">\n' +
                        '                        <a href="javascript:void(0);" class="add-item" data-description="#commendation-description" data-indicator="2">添加新项</a>\n' +
                        '                    </td>\n' +
                        '                </tr>'))
                }

            }
        })
    }

    function getFormData($trs, department) {
        var data = new Array();

        for (var i = 0; i < $trs.length; i++) {
            var $tr = $($($trs[i])[0]);
            var indicator = $tr.data("indicator")
            var score = $($tr.find('input[name="score"]')[0]).val()
            var evidenceFile = $($tr.find('input[name="evidenceFile"]')[0]).val()
            var comment = $($tr.find('textarea[name="comment"]')[0]).val()

            if (score.trim() != "" || comment.trim() != "" || evidenceFile.trim() != "") {
                if (score.trim() != "") {
                    var max = parseFloat($($tr.find('input[name="score"]')[0]).data('max'))
                    var min = parseFloat($($tr.find('input[name="score"]')[0]).data('min'))
                    if (parseFloat(score) > max)
                        score = max
                    if (parseFloat(score) < min)
                        score = min
                }

                var item = {
                    id: $tr.data('id'),
                    evidenceFile: evidenceFile,
                    indicator: indicator,
                    score: score,
                    comment: comment,
                    department: {id: department}
                };
                data.push(item);
            }
        }
        return data;
    }

    $('#contribution_self').on('click', '.delete-item', function (event) {
        var $tr = $(this).parent().parent()
        var $description = $($(this).data('description'))
        var id = $tr.data('id')

        if ($tr.find('td[rowspan]').size() != 0) {
            $tr.next().prepend($description)
        }

        if (id != null) {
            $.ajax({
                type: 'POST',
                data: {id: id},
                url: ctx + '/contribution_remove',
                success: function () {

                }
            })
        }

        $tr.remove()
        $description.attr('rowspan', parseInt($description.attr('rowspan')) - 1)
    })

    $('#contribution_self').on('click', '.add-item', function (event) {
        var $tr = $(this).parent().parent()
        var $description = $($(this).data('description'))
        var indicator = $(this).data('indicator')
        var $new_item = $('<tr data-indicator="' + indicator + '">\n' +
            '                    <td class="exclusion">\n' +
            '                        <input type="text" class="form-control" name="score" data-validate data-max="100" data-min="0">\n' +
            '                    </td>\n' +
            '                    <td>\n' +
            '                        <textarea class="form-control" name="comment"></textarea>\n' +
            '                    </td>\n' +
            '                    <td>\n' +
            '                        <p data-file></p>\n' +
            '                    </td>' +
            '                    <td>\n' +
            '                        <input type="hidden" name="evidenceFile">\n' +
            '                        <button class="btn btn-block btn-primary" data-target="#upload-modal" data-toggle="modal" type="button">上传文件</button>\n' +
            '                    </td>\n' +
            '                    <td>\n' +
            '                        <a href="javascript:void(0);" class="delete-item" data-description="' + $(this).data('description') + '">删除</a>\n' +
            '                    </td>\n' +
            '                </tr>')

        if ($tr.find('td[rowspan]').size() != 0) {
            $tr.find('td[rowspan]').remove()
            $new_item.prepend($description)
        }

        $tr.before($new_item)
        $description.attr('rowspan', parseInt($description.attr('rowspan')) + 1)
    })
})
