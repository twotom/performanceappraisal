<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
<#assign ctx = request.getContextPath() >

    <link href="${ ctx }/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${ ctx }/css/global.css" type="text/css" rel="stylesheet">
    <title>常州信息职业技术学院绩效考核系统</title>
</head>
<body>
<#include 'header_bar.ftl'>
<main>
    <h4 class="text-danger text-right">考核结束日期：${time}</h4>

    <input type="hidden" name="ctx" value="${ctx}" id="ctx">
    <#if employee.ranId?starts_with("A")>
        <#include 'satisfaction_superior.ftl'>
    <#elseif employee.ranId?starts_with("B")>
        <#include 'satisfaction_same.ftl'>
    <#else>
        <#include 'satisfaction_service.ftl'>
    </#if>

    <div class="modal fade" id="tip-modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body" id="tip-body">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                    <button type="button" class="btn btn-primary" id="confirm">确认提交</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="save-modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body">
                    <p class="bg-success">保存成功！</p>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="${ctx}/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/satisfaction.js"></script>
</main>

</body>
</html>
