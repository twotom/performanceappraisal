<div class="col-sm-1 sidebar">
    <ul class="nav nav-sidebar">
    <#if (employee.department.id / 100)?int == 2 && employee.identity.id == 21>
        <li><a href="#key_self" role="tab" data-toggle="tab" data-type="self">关键绩效-部门职责履行-重点工作（自评）</a></li>
        <li><a href="#contribution_self" role="tab" data-toggle="tab" data-type="contribution_self">例外绩效-突出贡献-部门上报</a></li>
    </#if>
    <#if employee.department.id == 101>
        <li><a href="#regular" role="tab" data-toggle="tab" data-type="regular">关键绩效-部门职责履行-常规工作</a></li>
    </#if>

    <#if employee.department.id == 101 || ((employee.group.id)?? && employee.group.id == 1)>
        <li><a href="#key" role="tab" data-toggle="tab">关键绩效-部门职责履行-重点工作</a></li>
    </#if>

    <#if employee.department.id == 204 && employee.identity.id == 21>
        <li><a href="#construction_political" role="tab" data-toggle="tab" data-type="routine">日常绩效-自身建设-宣传思想政治工作</a></li>
    </#if>
    <#if employee.department.id == 209 && employee.identity.id == 21>
        <li><a href="#construction_team" role="tab" data-toggle="tab" data-type="routine">日常绩效-自身建设-队伍建设</a></li>
    </#if>
    <#if employee.department.id == 202 && employee.identity.id == 21>
        <li><a href="#construction_clean" role="tab" data-toggle="tab" data-type="routine">日常绩效-自身建设-廉政建设</a></li>
    </#if>
    <#if employee.department.id == 215 && employee.identity.id == 21>
        <li><a href="#construction_system" role="tab" data-toggle="tab" data-type="routine">日常绩效-自身建设-制度建设</a></li>
    </#if>
    <#if employee.department.id == 201 && employee.identity.id == 21>
        <li><a href="#reasonable_timeliness" role="tab" data-toggle="tab" data-type="routine">日常绩效-工作规范-工作计划和总结报送的及时性</a>
        </li>
    </#if>
    <#if (employee.group.id)?? && employee.group.id == 3>
        <li><a href="#reasonable_archive" role="tab" data-toggle="tab" data-type="routine">日常绩效-工作规范-工作台账规范性</a></li>
    </#if>
    <#if employee.department.id == 206 && employee.identity.id == 21>
        <li><a href="#reasonable_safety" role="tab" data-toggle="tab" data-type="routine">日常绩效-工作规范-安全保卫</a></li>
    </#if>
    <#if employee.department.id == 218 && employee.identity.id == 21>
        <li><a href="#reasonable_equipment" role="tab" data-toggle="tab" data-type="routine">日常绩效-工作规范-资产设备保管环境卫生</a></li>
    </#if>
    <#if employee.department.id == 216 && employee.identity.id == 21>
        <li><a href="#reasonable_funding" role="tab" data-toggle="tab" data-type="routine">日常绩效-工作规范-经费预决算及规范使用</a></li>
    </#if>


    <#if (employee.group.id)?? && employee.group.id == 4>
        <li><a href="#contribution" role="tab" data-toggle="tab" data-type="contribution">例外绩效-突出贡献</a></li>
        <li><a href="#mistakes" role="tab" data-toggle="tab" data-type="mistake">例外绩效-严重失误-工作作风</a></li>
    </#if>
    <#if employee.department.id == 201 && employee.identity.id == 21>
        <li><a href="#mistakes" role="tab" data-toggle="tab" data-type="mistake">例外绩效-严重失误-工作失误</a></li>
    </#if>
    <#if employee.department.id == 209 && employee.identity.id == 21>
        <li><a href="#mistakes" role="tab" data-toggle="tab" data-type="mistake">例外绩效-严重失误-师德师风</a></li>
    </#if>
    <#if employee.department.id == 202 && employee.identity.id == 21>
        <li><a href="#mistakes" role="tab" data-toggle="tab" data-type="mistake">例外绩效-严重失误-党风廉政</a></li>
    </#if>
    <#if employee.department.id == 217 && employee.identity.id == 21>
        <li><a href="#mistakes" role="tab" data-toggle="tab" data-type="mistake">例外绩效-严重失误-审计问题</a></li>
    </#if>
    <#if employee.department.id == 206 && employee.identity.id == 21>
        <li><a href="#mistakes" role="tab" data-toggle="tab" data-type="mistake">例外绩效-严重失误-安全工作</a></li>
    </#if>

    <#if employee.identity.id == 11 || employee.identity.id == 12>
        <li><a href="#result" role="tab" data-toggle="tab" data-type="result">结果公示</a></li>
    </#if>
    <#if (employee.department.id / 100)?int == 2>
        <li><a href="#result-department" role="tab" data-toggle="tab" data-type="result">结果公示</a></li>
    </#if>
    <#if (employee.group.id)?? && employee.group.id == 1>
        <li><a href="#result-key" role="tab" data-toggle="tab" data-type="result_key">结果汇总-关键绩效</a></li>
    </#if>
    <#if (employee.group.id)?? && employee.group.id == 4>
        <li><a href="#result-satisfaction" role="tab" data-toggle="tab" data-type="result_satisfaction">结果汇总-满意度</a></li>
        <li><a href="#result-exception" role="tab" data-toggle="tab" data-type="result_exception">结果汇总-例外绩效</a></li>
    </#if>
    <#if (employee.group.id)?? && employee.group.id == 2>
        <li><a href="#result-daily" role="tab" data-toggle="tab" data-type="result_daily" data-item="1">结果汇总-自身建设</a></li>
    </#if>
    <#if (employee.group.id)?? && employee.group.id == 3>
        <li><a href="#result-daily" role="tab" data-toggle="tab" data-type="result_daily" data-item="2">结果汇总-工作规范</a></li>
    </#if>
</div>