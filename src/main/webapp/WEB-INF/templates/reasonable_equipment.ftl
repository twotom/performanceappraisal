<div class="tab-pane" id="reasonable_equipment" data-indicator="2" data-element="4">
    <h2 class="page-header">工作规范--资产设备保管及环境卫生</h2>

    <div class="well department-annotations">
        <p><span class="text-danger">注：</span>赋分方法</p>
        <p>1.资产设备的保管。无兼职资产管理员扣2.5分；未及时做好资产的入库、领用（接到通知7个工作日内计）、维护、标签管理、维（报）修、报废工作，每一项（次）扣1分，因保管不善造成资产丢失或因维护不及时造成资产损失扣2.5分。资产管理员不能及时调整更新部门资产账目的每次扣1分。</p>
        <p>2.资产设备的使用。发现有资产闲置一年及以上扣1分。</p>
        <p>3.办公室卫生整洁。地面、桌椅、橱柜有积尘，室内物品凌乱，每次扣1分。</p>
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
            <button class="btn btn-block btn-default routine_save" type="button" ${overtime?then("", "disabled")} title="${overtime?then("保存", "已超过截至日期")}" data-indicator="2" data-element="4">保存</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary routine_btn" type="button" ${overtime?then("", "disabled")} title="${overtime?then("提交", "已超过截至日期")}" data-indicator="2" data-element="4">提交</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary" type="button" data-preview>打印</button>
        </div>
    </form>
</div>