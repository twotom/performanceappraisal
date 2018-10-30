$(function () {
    var $login_form = $('#login')
    var $login_btn = $('#login_btn')
    var $empId_input = $('#empId')
    var $password_input = $('#password')
    var $helpBlock = $('#helpBlock')
    var redirect = $login_form.data('redirect')
    $login_btn.on('click', function (e) {
        login();
    })

    $empId_input.blur(function (event) {
        no_validate($empId_input.val())
    })

    function no_validate(no) {
        var reg = /[A-Za-z]\d{5}/
        if (reg.test(no)) {
            $empId_input.data('validate', true)
            $helpBlock.addClass('invisible').html('')
        } else {
            $empId_input.data('validate', false)
            $helpBlock.removeClass('invisible').html('账号格式错误！')
        }
    }

    $password_input.blur(function (event) {
        pwd_validate($password_input.val())
    })

    function pwd_validate(pwd) {
        if (pwd.trim() != '') {
            $password_input.data('validate', true)
            $helpBlock.addClass('invisible').html('')
        } else {
            $password_input.data('validate', false)
            $helpBlock.removeClass('invisible').html('请输入密码！')
        }
    }

    function login() {
        var empId = $empId_input.val()
        var password = $password_input.val()
        if (($empId_input.data('validate') || no_validate(empId)) && ($password_input.data('validate') || pwd_validate(password))) {
            $.ajax({
                type: 'POST',
                data: {
                    ranId: empId,
                    ranPwd: password,
                },
                url: $login_form.attr('action'),
                success: function (data) {
                    if (data == 'N') {
                        $helpBlock.html('账号或密码错误！').removeClass('invisible');
                    } else {
                        window.location = redirect;
                    }
                }
            })
        }

    }
});
