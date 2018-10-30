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
            <form action="${ctx}/satisfaction_login" class="form-horizontal" id="login" data-redirect="${ctx}/satisfaction">
                <h3 class="login-header">登录</h3>
                <div class="form-group">
                    <label for="no" class="col-sm-2 control-label">账号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="empId" placeholder="请输入账号">
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
                    <div class="col-sm-offset-2 col-sm-8">
                        <button type="button" class="btn btn-block btn-primary" id="login_btn">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<#include '../copyright.ftl'>
</main>

<script type="text/javascript" src="${ctx}/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/s_login.js"></script>
</body>
</html>