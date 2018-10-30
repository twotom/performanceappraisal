<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">

    <#assign ctx = request.getContextPath() >
    <link href="${ ctx }/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${ ctx }/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet">

    <title>设定考核结束时间</title>
</head>
<body>
<main>
    <input type="hidden" name="ctx" value="${ctx}" id="ctx">

    <h2 class="page-header text-center">设定考核结束时间</h2>
    <div class="container">
        <form action="" class="form-horizontal" role="form">
            <div class="form-group">
                <label for="time" class="col-md-2 col-sm-offset-2 control-label">结束时间：</label>
                <div class="input-group date form_datetime col-md-4">
                    <input class="form-control" id="time" size="21" type="text" name="stime" value="${time???then(time, "")}" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-2 col-sm-offset-6">
                    <button class="btn btn-block btn-primary" type="button" id="submit">提交</button>
                </div>
            </div>
        </form>
    </div>

    <div class="modal fade" id="tip">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body" id="tip-body">
                </div>
            </div>
        </div>
    </div>
</main>

<script type="text/javascript" src="${ctx}/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${ctx}/js/time.js"></script>
</body>
</html>