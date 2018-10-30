<div class="tab-pane" id="regular">
    <h2 class="page-header">常规工作</h2>

    <div class="well department-annotations">
        <p><span class="text-danger">注：</span>赋分方法</p>
        <p>1.计划性主要考核部门工作是否按计划展开、安排是否合理；规范性主要考核部门是否按规范开展工作；有效性主要考核部门常规工作目标是否达成及完成质量情况；</p>
        <p>2.赋分时综合考虑“计划性、规范性、有效性”三项考核要素，完成情况非常好为A档，较好为B档，基本达标为C档，不达标为D档；</p>
        <p>3.对每项工作进行综合打分，赋分点：A档（100分）、B档（90分）、C档（80分）、D档（50分）四档。</p>
    </div>

    <div class="table-responsive">
        <table class="table table-bordered table-striped table-hover">
            <thead>
            <tr>
                <th>职能部门</th>
                <th>赋分</th>
            </tr>
            </thead>
            <tbody>
            <#list departments as department>
            <tr>
                <td>${department.shortName}</td>
                <td class="radio-oneline">
                    <div class="radio">
                        <label>
                            <input type="radio" name="${department.id}" value="1">
                            A档
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="${department.id}" value="2">
                            B档
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="${department.id}" value="3">
                            C档
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="${department.id}" value="4">
                            D档
                        </label>
                    </div>
                </td>
            </tr>
            </#list>
            </tbody>
        </table>
        <div class="col-sm-2 col-sm-offset-3">
            <button class="btn btn-block btn-default regular_save" ${overtime?then("", "disabled")} title="${overtime?then("保存", "已超过截至日期")}" type="button">保存</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary regular_btn" ${overtime?then("", "disabled")} title="${overtime?then("提交", "已超过截至日期")}" type="button">提交</button>
        </div>
    </div>
</div>