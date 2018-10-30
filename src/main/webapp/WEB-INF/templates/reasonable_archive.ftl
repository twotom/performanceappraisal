<div class="tab-pane" id="reasonable_archive" data-indicator="2" data-element="2">
    <h2 class="page-header">工作规范--工作台账规范性</h2>

    <div class="well department-annotations">
        <p><span class="text-danger">注：</span>赋分方法</p>
        <p>1.台账的设置。根据部门职责设置必要的台账，并形成清晰的台账目录，每年初报考核小组备案。</p>
        <p>2.台帐的记录。工作台帐必须记录真实，内容完整，填制及时，未按要求做好记录的，每项工作台帐扣0.1分，累计扣分不超过1分；</p>
        <p>3.台帐的保管。工作台帐必须由专人保管，防止遗失，必要时做好保密工作，未按要求做好保管工作的，每项工作台帐扣0.1分，累计扣分不超过0.5分；</p>
        <p>4.台帐在本部门归档。台帐资料归档不完整或整理不规范的，每次扣0.1分，累计扣分不超过0.5分。（台账归档检查仅针对上一年度台账）以上项目累计扣分不超过2分。</p>
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
            <button class="btn btn-block btn-default routine_save" type="button" ${overtime?then("", "disabled")} title="${overtime?then("保存", "已超过截至日期")}" data-indicator="2" data-element="2">保存</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary routine_btn" type="button" ${overtime?then("", "disabled")} title="${overtime?then("提交", "已超过截至日期")}" data-indicator="2" data-element="2">提交</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary" type="button" data-preview>打印</button>
        </div>
    </form>

</div>