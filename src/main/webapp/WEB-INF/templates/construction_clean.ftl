<div class="tab-pane" id="construction_clean" data-indicator="1" data-element="3">
    <h2 class="page-header">自身建设--廉政建设</h2>

    <div class="well department-annotations">
        <p><span class="text-danger">注：</span>赋分方法</p>
        <p>未按学院要求完成行政权力清单规范制定及行政权力网上公开运行工作、未按学院要求完成廉政建设工作任务、未认真履行学院党风廉政建设责任制相关要求、未认真执行《中央八项规定精神》及坚决纠正“四风”问题等情况，每发现一项（次）扣0.5分，累计扣分不超过2分。</p>
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
            <button class="btn btn-block btn-default routine_save" ${overtime?then("", "disabled")} title="${overtime?then("保存", "已超过截至日期")}" type="button" data-indicator="1" data-element="3">保存</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary routine_btn" ${overtime?then("", "disabled")} title="${overtime?then("提交", "已超过截至日期")}" type="button" data-indicator="1" data-element="3">提交</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary" type="button" data-preview>打印</button>
        </div>
    </form>

</div>