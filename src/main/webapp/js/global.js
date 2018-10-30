$('#upload').fileinput({
    language: 'zh', //设置语言
    uploadUrl: '/upload',  //上传地址
    uploadAsync: true,
    dropZoneEnabled: false,
    allowedFileExtensions: ['zip', 'rar'],
    maxFileCount: 1,
    showPreview: false,
    elErrorContainer: "#errorcontainer"
})
//同步上传返回结果处理

$("#upload").on("fileuploaded", function (event, data, previewId, index) {
    $(event.target).data('filename', data.filenames[0])
    $(event.target).data('upload', data.response['message'])

})

$('#upload-modal').on('hide.bs.modal', function (event) {
    if ($('#upload').data('upload') != null && $('#upload').data('upload').trim() != "") {
        var upload = $('#upload').data('upload').trim()
        var filename = $('#upload').data('filename').trim()
        $($(this).data('relatedTarget')).prev().val(upload)
        $($(this).data('relatedTarget')).parent().prev().find('p[data-file]').html(filename + '<span class="text-danger">(待提交)</span>').addClass('bg-success')
    }
    $('#upload').data('filename', '')
    $('#upload').data('upload', '')
})

$('#upload-modal').on('show.bs.modal', function (event) {
    document.getElementById("upload-form").reset();
    $(this).data('relatedTarget', event.relatedTarget)
})

$('#tip-modal').on('hidden.bs.modal', function (e) {
    $('#confirm').off('click')
})

$('input[name^="score"]').on('keydown', function (event) {
    if (event.keyCode != 190 && event.keyCode != 8 && event.keyCode != 189 && event.keyCode != 109 && event.keyCode != 110 && (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105)) {
        event.preventDefault()
    }
})

$(document).on('blur', 'input[data-validate]', function (event) {
    var max = parseFloat($(this).data('max'))
    var min = parseFloat($(this).data('min'))
    var reg = /^-?\d+(\.\d+)?$/
    var val = $(this).val()
    var $help = $(this).next()
    if ($help.length == 0) {
        $help = $('<span class=\"help-block hidden text-center bg-danger"></span>')
        $(this).after($help)
    }

    if (!reg.test(val)) {
        $(this).val('')
        $help.removeClass('hidden').html('请输入有效的分值！')
        return
    } else {
        val = parseFloat(val)
    }
    if ($(this).data('validate') == 'negative') {
        if (val > 0) {
            val = -val
            $(this).val(val)
        }
    }
    if (val < min || val > max) {
        $help.removeClass('hidden').html('分值在' + min + '-' + max + '之间')
    } else {
        $(this).next().addClass('hidden')
    }


})