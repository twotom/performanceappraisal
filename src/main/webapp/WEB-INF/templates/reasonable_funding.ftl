<div class="tab-pane" id="reasonable_funding" data-indicator="2" data-element="5">
    <h2 class="page-header">工作规范--经费预决算及规范使用</h2>

    <div class="well department-annotations">
        <p><span class="text-danger">注：</span>赋分方法</p>
        <p>1.部门经费预算制定合理、使用规范、执行情况达标。违规一次扣0.2分，出现严重违规此项不得分。累计扣分不超过1分。</p>
        <p>2.每年9月底预算执行率不低于75%，每低一个百分点，扣0.02分。累计扣分不超过0.5分。</p>
        <p>3.全年预算执行率不低于整个预算经费95%。每低一个百分点，扣0.02分。累计扣分不超过0.5分。</p>
        <p>以上项目累计扣分不超过2分。</p>
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
                        <input type="text" class="form-control" name="score" data-validate data-max="2" data-min="0">
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
                    <td>2</td>
                </tr>
                </#list>

                </tbody>
            </table>
        </div>
        <div class="col-sm-2 col-sm-offset-1">
            <button class="btn btn-block btn-default routine_save" type="button" ${overtime?then("", "disabled")} title="${overtime?then("保存", "已超过截至日期")}" data-indicator="2" data-element="5">保存</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary routine_btn" type="button" ${overtime?then("", "disabled")} title="${overtime?then("提交", "已超过截至日期")}" data-indicator="2" data-element="5">提交</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary" type="button" data-preview>打印</button>
        </div>
    </form>

</div>