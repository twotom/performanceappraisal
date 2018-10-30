<div class="tab-pane" id="mistakes" data-second="5">

    <form>
        <h2 class="page-header">严重失误--审计问题</h2>

        <div class="well department-annotations">
            <p><span class="text-danger">注：</span>赋分方法</p>
            <p>1、因工作失误对学院工作造成重大影响，依据处理结果，视情节严重情况扣1-5分。</p>
            <p>2、因不重视工作作风建设，造成对同一问题投诉较多，且在半年内未整改或整改效果不明显，或者存在工作效率低下、无故拖拉推卸工作现象。</p>
            <p>3、因违社会公德、家庭美德、职业道德造成学院声誉受损或影响工作秩序的，依据处理结果，视情节严重情况扣1-5分。</p>
            <p>4、有信访举报经查实或党风廉政责任制检查考核等发现有问题并造成学院声誉、经济等受损的，依据处理结果，视情节严重情况扣1-10分。</p>
            <p>5、审计发现有问题并造成学院声誉、经济等受损的，依据处理结果，视情节严重情况扣1-10分。</p>
            <p>6、发生严重影响学校和社会安全稳定的安全责任事故，依据处理结果，视情节严重情况扣1-10分。</p>
        </div>

        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>部门</th>
                    <th>赋分</th>
                    <th>扣分说明</th>
                    <th>已上传材料</th>
                    <th>佐证材料</th>
                </tr>
                </thead>
                <tbody>
                <#list departments as department>
                <tr data-department="${department.id}" data-second="5">
                    <td>${department.shortName}</td>
                    <td class="exclusion">
                        <input type="text" class="form-control" name="score" data-validate="negative" data-max="0"
                               data-min="-10">
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
                        <button class="btn btn-block btn-primary">上传文件</button>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col-sm-2 col-sm-offset-1">
            <button class="btn btn-block btn-default mistake_save" ${overtime?then("", "disabled")} title="${overtime?then("保存", "已超过截至日期")}" type="button">保存</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary mistake_btn" ${overtime?then("", "disabled")} title="${overtime?then("提交", "已超过截至日期")}" type="button">提交</button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary" type="button" data-mp>打印</button>
        </div>
    </form>
</div>