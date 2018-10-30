<div class="tab-pane" id="reasonable_timeliness" data-indicator="2" data-element="1">
    <h2 class="page-header">工作规范--工作计划和总结报送的及时性</h2>

    <div class="well department-annotations">
        <p><span class="text-danger">注：</span>赋分方法</p>
        <p>1.工作计划、工作总结按时上交。年度工作计划、工作总结无特殊原因未按时上交，扣0.5分；月度工作计划、工作总结未按时上交或不符合要求被退回，每次扣0.1分，累计扣分不超过0.5分；</p>
        <p>2.明确要求归档的工作资料按时递交归档。无特殊原因未按时归档的，每次扣0.1分，累计扣分不超过0.5分。以上项目累计扣分不超过1分。</p>
    </div>

    <form>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>职能部门</th>
                    <th>赋分</th>
                    <th>说明</th>
                    <th>已上传材料</th>
                    <th>佐证材料</th>
                    <th>满分值</th>
                </tr>
                </thead>
                <tbody>
                <#list departments as department>
                <tr data-department="${department.id}">
                    <td>${department.shortName}</td>
                    <td class="exclusion">
                        <input type="text" class="form-control" name="score" data-validate data-max="1" data-min="0">
                        <span class="help-block hidden text-center bg-danger"></span>
                    </td>
                    <td>
                        <textarea class="form-control" name="comment"></textarea>
                    </td>
                    <td>
                        <p data-file></p>
                    </td>
                    <td>
                        <input type="hidden" name="evidenceFile">
                        <button class="btn btn-block btn-primary" data-target="#upload-modal" data-toggle="modal" type="button">上传文件</button>
                    </td>
                    <td>1</td>
                </tr>
                </#list>

                </tbody>
            </table>
        </div>
        <div class="col-sm-2 col-sm-offset-1">
            <button class="btn btn-block btn-default routine_save" type="button" ${overtime?then("", "disabled")} title="${overtime?then("保存", "已超过截至日期")}" data-indicator="2" data-element="1">保存</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary routine_btn" type="button" ${overtime?then("", "disabled")} title="${overtime?then("提交", "已超过截至日期")}" data-indicator="2" data-element="1">提交</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary" type="button" data-preview>打印</button>
        </div>
    </form>
</div>