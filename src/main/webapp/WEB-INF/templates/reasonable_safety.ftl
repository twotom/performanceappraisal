<div class="tab-pane" id="reasonable_safety" data-indicator="2" data-element="3">
    <h2 class="page-header">工作规范--安全保卫</h2>

    <div class="well department-annotations">
        <p><span class="text-danger">注：</span>赋分方法</p>
        <p>1.安全保障全面。无安全管理制度（含安全责任制）扣0.2分；无兼职安全员扣0.2分；无安全检查台账扣0.2分。</p>
        <p>2.排除安全隐患。检查发现明显安全隐患且未整改或未报修，或使用大功率电器，每次扣0.2分。</p>
        <p>3.车辆停放规范。发现在规定区域以外停放车辆，每次扣0.1分。</p>
        <p>4.车辆安全行驶。车辆违反指示牌规定的时间、区域、速度行驶，每次扣0.2分。</p>
        <p>5.遵守控烟规定。在非吸烟区吸烟，每次扣0.1分。</p>
        <p>以上项目累计扣分不超过2.5分。</p>
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
                        <input type="text" class="form-control" name="score" data-validate data-max="2.5" data-min="0">
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
                    <td>2.5</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col-sm-2 col-sm-offset-1">
            <button class="btn btn-block btn-default routine_save" type="button" ${overtime?then("", "disabled")} title="${overtime?then("保存", "已超过截至日期")}" data-indicator="2" data-element="3">保存</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary routine_btn" type="button" ${overtime?then("", "disabled")} title="${overtime?then("提交", "已超过截至日期")}" data-indicator="2" data-element="3">提交</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary" type="button" data-preview>打印</button>
        </div>
    </form>

</div>