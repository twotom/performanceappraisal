<div class="tab-pane" id="construction_political" data-indicator="1" data-element="1">
    <h2 class="page-header">自身建设--宣传思想政治工作</h2>

    <div class="well department-annotations">
        <p><span class="text-danger">注：</span>赋分方法</p>
        <p>1.部门人员未完成由学校统一安排的政治学习任务，每人扣0.1分。</p>
        <p>2.部门未完成学院宣传思想文化工作主题活动的开展（由宣传部提前与部门沟通并以文件形式通知），每次扣0.1分</p>
        <p>3.部门不配合学院宣传报道新闻线索及材料组织的，每次扣0.1分。</p>
        <p>部门累计扣分不超过1分。</p>
    </div>
    <form>
        <div class="table-responsive">
            <table class="table table-striped table-hover table-bordered">
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
                    <td>3</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col-sm-2 col-sm-offset-1">
            <button class="btn btn-block btn-default routine_save" type="button" ${overtime?then("", "disabled")} title="${overtime?then("保存", "已超过截至日期")}" data-indicator="1" data-element="1">保存</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary routine_btn" type="button" ${overtime?then("", "disabled")} title="${overtime?then("提交", "已超过截至日期")}" data-indicator="1" data-element="1">提交</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary" type="button" data-preview>打印</button>
        </div>
    </form>


</div>