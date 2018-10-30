<div class="tab-pane" id="key">
    <h2 class="page-header">重点工作</h2>

    <div class="well department-annotations">
        <p><span class="text-danger">注：</span>赋分方法</p>
        <p>1.赋分时采用“定档、定级、定系数”的方法，针对每项工作任务进行赋分；</p>
        <p>
            2.定档，依据《部门重点工作任务分解实施表》所列“工作任务”的“难易度、重要度”两个要素，分A、B、C三个档次；定级，依据《部门重点工作任务分解实施表》所列“考核要点”完成的“成效与创新度”，在A、B、C每个档次中划分1、2、3三个级别；由定档、定级形成了档级系数；档级系数的赋分点：A档（A1=95，A2=92，A3=90），B档（B1=88，B2=84,
            B3=80），C档（C1=78，C2=74，C3=70）；</p>
        <p>3.定系数，依据《部门重点工作任务分解实施表》所列“工作任务”的任务数量、任务工作量以及部门人数等因素给定工作负荷系数K，分三档；负荷系数取值：K1=1，K2=0.95，K3=0.90；</p>
        <p>4.得分值=(∑档级系数对应的赋分)×负荷系数K/工作任务总数。</p>
    </div>

    <div>
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
        <#list departments as department>
            <li role="presentation"><a href="#department-${department.id}" role="tab"
                                       data-toggle="tab" data-type="key-work">${department.shortName}</a></li>
        </#list>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
        <#list departments as department>
            <#include 'department_key/${department.id}.ftl'>
        </#list>
        </div>

    </div>
</div>

