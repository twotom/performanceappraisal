<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <#assign ctx = request.getContextPath() >

    <link href="${ ctx }/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${ ctx }/css/fileinput.min.css" type="text/css" rel="stylesheet">
    <link href="${ ctx }/css/global.css" type="text/css" rel="stylesheet">
    <link href="${ ctx }/css/print.css" type="text/css" rel="stylesheet" media="print">
    <title>常州信息职业技术学院绩效考核系统</title>
</head>
<body>
<#include 'header_bar.ftl'>
<main>
    <input type="hidden" name="ctx" value="${ctx}" id="ctx">
    <#include 'side_bar.ftl'>

    <div class="col-sm-11 col-sm-offset-1 main">
        <h4 class="text-danger text-right">考核结束日期：${time}</h4>

        <div class="tab-content">
        <#if (employee.department.id / 100)?int == 2 && employee.identity.id == 21>
            <#include 'key_work_self.ftl'>
            <#include 'contribution_self.ftl'>
        </#if>

        <#if employee.department.id == 101>
            <#include 'regular.ftl'>
        </#if>

        <#if employee.department.id == 101 || ((employee.group.id)?? && employee.group.id == 1)>
            <#include 'key_work.ftl'>
        </#if>

        <#if employee.department.id == 204 && employee.identity.id == 21>
            <#include 'construction_political.ftl'>
        </#if>
        <#if employee.department.id == 209 && employee.identity.id == 21>
            <#include 'construction_team.ftl'>
        </#if>
        <#if employee.department.id == 202 && employee.identity.id == 21>
            <#include 'construction_clean.ftl'>
        </#if>
        <#if employee.department.id == 215 && employee.identity.id == 21>
            <#include 'construction_system.ftl'>
        </#if>
        <#if employee.department.id == 201 && employee.identity.id == 21>
            <#include 'reasonable_timeliness.ftl'>
        </#if>
        <#if (employee.group.id)?? && employee.group.id == 3>
            <#include 'reasonable_archive.ftl'>
        </#if>
        <#if employee.department.id == 206 && employee.identity.id == 21>
            <#include 'reasonable_safety.ftl'>
        </#if>
        <#if employee.department.id == 218 && employee.identity.id == 21>
            <#include 'reasonable_equipment.ftl'>
        </#if>
        <#if employee.department.id == 216 && employee.identity.id == 21>
            <#include 'reasonable_funding.ftl'>
        </#if>


        <#if (employee.group.id)?? && employee.group.id == 4>
            <#include 'contribution.ftl'>
            <#include 'mistake_style.ftl'>
        </#if>
        <#if employee.department.id == 201 && employee.identity.id == 21>
            <#include 'mistake_work.ftl'>
        </#if>
        <#if employee.department.id == 209 && employee.identity.id == 21>
            <#include 'mistake_character.ftl'>
        </#if>
        <#if employee.department.id == 202 && employee.identity.id == 21>
            <#include 'mistake_clean.ftl'>
        </#if>
        <#if employee.department.id == 217 && employee.identity.id == 21>
            <#include 'mistake_audit.ftl'>
        </#if>
        <#if employee.department.id == 206 && employee.identity.id == 21>
            <#include 'mistake_safety.ftl'>
        </#if>

        <#if employee.identity.id == 11 || employee.identity.id == 12>
            <#include 'result.ftl'>
        </#if>

        <#if (employee.department.id / 100)?int == 2>
            <#include 'result_department.ftl'>
        </#if>
        <#if (employee.group.id)?? && employee.group.id  == 1>
            <#include 'result_key.ftl'>
        </#if>
        <#if (employee.group.id)?? && employee.group.id  == 4>
            <#include 'result_satisfaction.ftl'>
            <#include 'result_exception.ftl'>
        </#if>
        <#if (employee.group.id)?? && employee.group.id  == 2>
            <#include 'result_construction.ftl'>
        </#if>
        <#if (employee.group.id)?? && employee.group.id  == 3>
            <#include 'result_reasonable.ftl'>
        </#if>
        </div>
    </div>

    <div class="modal fade" id="upload-modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                    <h4 class="modal-title">上传文件</h4>
                </div>
                <div class="modal-body">
                    <div class="container-fluid">
                        <div class="col-md-12">
                            <form id="upload-form">
                                <input name="file" type="file" multiple id="upload" class="file-loading">
                            </form>
                        </div>
                    </div>
                    <div class="container-fluid" id="errorcontainer">
                    </div>
                </div>
            </div>
        </div>
    </div>

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
                        保存成功
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="${ctx}/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/piexif.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/purify.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/sortable.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/fileinput.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/zh.js"></script>
    <script type="text/javascript" src="${ctx}/js/global.js"></script>
    <script type="text/javascript" src="${ctx}/js/regular.js"></script>
    <script type="text/javascript" src="${ctx}/js/satisfaction.js"></script>
    <script type="text/javascript" src="${ctx}/js/routine.js"></script>
    <script type="text/javascript" src="${ctx}/js/self.js"></script>
    <script type="text/javascript" src="${ctx}/js/keywork.js"></script>
    <script type="text/javascript" src="${ctx}/js/mistake.js"></script>
    <script type="text/javascript" src="${ctx}/js/contribution_self.js"></script>
    <script type="text/javascript" src="${ctx}/js/contribution.js"></script>
    <script type="text/javascript" src="${ctx}/js/jQuery.print.js"></script>
    <#if employee.identity.id == 11 || employee.identity.id == 12>
        <script type="text/javascript" src="${ctx}/js/result.js"></script>
    </#if>

    <#if (employee.department.id / 100)?int == 2>
        <script type="text/javascript" src="${ctx}/js/result_department.js"></script>
    </#if>
    <#if (employee.group.id)?? && employee.group.id  == 1>
        <script type="text/javascript" src="${ctx}/js/result_key.js"></script>
    </#if>
    <#if (employee.group.id)?? && employee.group.id  == 4>
        <script type="text/javascript" src="${ctx}/js/result_satisfaction.js"></script>
        <script type="text/javascript" src="${ctx}/js/result_exception.js"></script>
    </#if>
    <#if (employee.group.id)?? && (employee.group.id == 2 || employee.group.id == 3)>
        <script type="text/javascript" src="${ctx}/js/result_daily.js"></script>
    </#if>
</main>

</body>
</html>
