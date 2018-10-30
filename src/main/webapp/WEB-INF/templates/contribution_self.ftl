<div class="tab-pane" id="contribution_self" data-department="${employee.department.id}">
    <h2 class="page-header">重大贡献--部门上报</h2>

    <div class="well department-annotations">
        <p><span class="text-danger">注：</span>申报要求</p>
        <p>重大贡献:提升学院综合社会影响、提高学院经济效益、对学院当前重点工作有重大支撑。</p>
        <p>奖励表彰:部门获表彰情况（国家级、省级、市级）。</p>
    </div>

    <form>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>贡献类型</th>
                    <th>自评分</th>
                    <th>评分说明</th>
                    <th>已上传材料</th>
                    <th>佐证材料</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="contribution-content" data-department="${employee.department.id}">

                </tbody>
            </table>
        </div>
        <div class="col-sm-2 col-sm-offset-3">
            <button class="btn btn-block btn-default contribution_self_save"
                    data-department="${employee.department.id}" ${overtime?then("", "disabled")} title="${overtime?then("保存", "已超过截至日期")}" type="button">保存
            </button>
        </div>
        <div class="col-sm-2 col-sm-offset-2">
            <button class="btn btn-block btn-primary contribution_self_btn"
                    data-department="${employee.department.id}" ${overtime?then("", "disabled")} title="${overtime?then("提交", "已超过截至日期")}" type="button">提交
            </button>
        </div>
    </form>
</div>