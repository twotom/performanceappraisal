<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <#assign ctx = request.getContextPath() >

    <link href="${ ctx }/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${ ctx }/css/login.css" type="text/css" rel="stylesheet">
    <title>常州信息职业技术学院绩效考核系统--登录</title>
</head>
<body>

<main class="container-fluid">
    <div class="container">
        <div class="col-sm-4 pull-right login-box">
            <form action="${ctx}/login_validate" class="form-horizontal" id="login" data-redirect="${ctx}/profile">
                <h3 class="login-header">登录</h3>
                <div class="form-group">
                    <label for="no" class="col-sm-2 control-label">工号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="empId" placeholder="请输入工号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" placeholder="请输入密码">
                    </div>
                </div>
                <span id="helpBlock" class="help-block invisible text-center bg-danger"></span>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-4">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="remember" id="remember">记住我
                            </label>
                        </div>
                    </div>
                    <div class="col-sm-4 pull-right forgetps-link">
                        <a class="text-danger" href="#tip" data-toggle="modal">忘记密码？</a>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-8">
                        <button type="button" class="btn btn-block btn-primary" id="login_btn">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <#include 'copyright.ftl'>
</main>

<div class="modal fade" id="tip" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">友情提示</h4>
            </div>
            <div class="modal-body">
                <div class="alert alert-success" role="alert">
                    <p>默认密码为工号后6位，若忘记密码请联系管理员！</p>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${ctx}/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/login.js"></script>
</body>
</html>