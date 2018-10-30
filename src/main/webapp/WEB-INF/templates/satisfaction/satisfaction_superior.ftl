<div class="container" id="satisfaction" data-indicator="1">
    <h2 class="page-header">满意度评价--上级评价</h2>

    <div class="well department-annotations">
        <p><span class="text-danger">注：</span>赋分方法</p>
        <p>每个考核要素分为A（非常满意）、B（满意）、C（基本满意）、D（不满意）4个评价档次，分别对应A档90分、B档80分、C档70分、D档50分。</p>
    </div>
    <form>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>部门</th>
                    <th>赋分</th>
                    <th>考核要素</th>
                    <th>满分值</th>
                </tr>
                </thead>
                <tbody>
                <#assign elements = ['工作思路', '执行能力', '工作成效', '创新能力']>
                <#list departments as department>
                    <#list elements as element>
                        <#if element?counter == 1>
                        <tr>
                            <td rowspan="4" class="rowspan">${department.shortName}</td>
                            <td class="radio-oneline">
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="${department.id}_${element?counter}" value="1">
                                        A档
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="${department.id}_${element?counter}" value="2">
                                        B档
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="${department.id}_${element?counter}" value="3">
                                        C档
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="${department.id}_${element?counter}" value="4">
                                        D档
                                    </label>
                                </div>
                            </td>
                            <td>${element}</td>
                            <td rowspan="4" class="rowspan">15</td>
                        </tr>
                        <#else >
                        <tr>
                            <td class="radio-oneline">
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="${department.id}_${element?counter}" value="1">
                                        A档
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="${department.id}_${element?counter}" value="2">
                                        B档
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="${department.id}_${element?counter}" value="3">
                                        C档
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="${department.id}_${element?counter}" value="4">
                                        D档
                                    </label>
                                </div>
                            </td>
                            <td>${element}</td>
                        </tr>
                        </#if>
                    </#list>
                </#list>
                </tbody>
            </table>
        </div>

        <div class="col-sm-2 col-sm-offset-10">
            <button class="btn btn-block btn-primary satisfaction_btn" ${overtime?then("", "disabled")} title="${overtime?then("提交", "已超过截至日期")}" type="button" data-indicator="1">
                提交
            </button>
        </div>
    </form>
</div>


