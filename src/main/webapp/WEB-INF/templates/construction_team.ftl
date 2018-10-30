<div class="tab-pane" id="construction_team" data-indicator="1" data-element="2">
    <h2 class="page-header">自身建设--队伍建设</h2>

    <div class="well department-annotations">
        <p><span class="text-danger">注：</span>赋分方法</p>
        <p>1.严格遵守校纪校规和师德师风相关规定，违反一次扣0.2分，累计扣分不超过2分。</p>
        <p>2.认真执行考勤制度。无故缺勤或代刷卡每次扣0.1分，累计扣分不超过1分。</p>
        <p>3.积极参加业务学习与培训，培训人员需达到部门人数的20%，少1人扣0.2分，培训学习中出现被投诉批评情况，扣0.2分/人次，累计扣分不超过1分</p>
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
                        <input type="text" class="form-control" name="score" data-validate data-max="4" data-min="0">
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
                    <td>4</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col-sm-2 col-sm-offset-1">
            <button class="btn btn-block btn-default routine_save" type="button" ${overtime?then("", "disabled")} title="${overtime?then("保存", "已超过截至日期")}" data-indicator="1" data-element="2">保存</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary routine_btn" type="button" ${overtime?then("", "disabled")} title="${overtime?then("提交", "已超过截至日期")}" data-indicator="1" data-element="2">提交</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary" type="button" data-preview>打印</button>
        </div>
    </form>

</div>