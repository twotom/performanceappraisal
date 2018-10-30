<div class="table-responsive">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>是否完成</th>
            <th>自评分</th>
            <th>详细说明</th>
            <th>工作任务</th>
            <th class="exclusion-description">任务分解/时序进度</th>
            <th>考核要点</th>
        </tr>
        </thead>
        <tbody>
        <tr data-task="113">
            <td rowspan="2" class="radio-oneline rowspan">
                <div class="radio">
                    <label>
                        <input type="radio" name="finish_113" value="true">
                        已完成
                    </label>
                </div>
                <div class="radio">
                    <label class="text-danger">
                        <input type="radio" name="finish_113" value="false">
                        未完成
                    </label>
                </div>
            </td>
            <td rowspan="2" class="exclusion rowspan">
                <input type="text" class="form-control" data-validate data-max="100" data-min="0" data-validate data-max="100" name="score_113">
            </td>
            <td rowspan="2" class="rowspan">
                <textarea class="form-control" name="comment_113"></textarea>
            </td>
            <td rowspan="2" class="rowspan">2016年中层干部经济责任使用审计与督促整改</td>
            <td>
                <p>3月：配合组织部门对2016年中层干部经济责任审计中的问题提出整改建议</p>
            </td>
            <td>
                <p>提出书面整改建议</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>4~12月：推进相关部门落实整改</p>
            </td>
            <td>
                <p>根据学院要求协助落实问题整改</p>
            </td>
        </tr>
        <tr data-task="114">
            <td rowspan="3" class="radio-oneline rowspan">
                <div class="radio">
                    <label>
                        <input type="radio" name="finish_114" value="true">
                        已完成
                    </label>
                </div>
                <div class="radio">
                    <label class="text-danger">
                        <input type="radio" name="finish_114" value="false">
                        未完成
                    </label>
                </div>
            </td>
            <td rowspan="3" class="exclusion rowspan">
                <input type="text" class="form-control" data-validate data-max="100" data-min="0" data-validate data-max="100" name="score_114">
            </td>
            <td rowspan="3" class="rowspan">
                <textarea class="form-control" name="comment_114"></textarea>
            </td>
            <td rowspan="3" class="rowspan">2016年部门经费使用审计与督促整改</td>
            <td>
                <p>3月：提出审计方案，确定审计机构，做好审计前准备工作</p>
            </td>
            <td>
                <p>确定审计机构，完成方案制定及审计准备工作</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>4~5月：审计工作实施、总结、出具报告</p>
            </td>
            <td>
                <p>协助审计单位完成审计，并提出整改建议</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>6~12月：对审计结果中出现的问题提出整改建议，下发整改通知书推进部门落实整改</p>
            </td>
            <td>
                <p>督促部门完成整改</p>
            </td>
        </tr>
        <tr data-task="115">
            <td rowspan="1" class="radio-oneline rowspan">
                <div class="radio">
                    <label>
                        <input type="radio" name="finish_115" value="true">
                        已完成
                    </label>
                </div>
                <div class="radio">
                    <label class="text-danger">
                        <input type="radio" name="finish_115" value="false">
                        未完成
                    </label>
                </div>
            </td>
            <td rowspan="1" class="exclusion rowspan">
                <input type="text" class="form-control" data-validate data-max="100" data-min="0" data-validate data-max="100" name="score_115">
            </td>
            <td rowspan="1" class="rowspan">
                <textarea class="form-control" name="comment_115"></textarea>
            </td>
            <td rowspan="1" class="rowspan">加强对重大专项实施过程中的前期介入和过程跟进</td>
            <td>
                <p>3~12月：在各重大专项的实施过程中加大前期的监督建议与过程的跟踪监督。</p>
            </td>
            <td>
                <p>对重大专项的前期与过程审计监督汇总材料</p>
            </td>
        </tr>

        </tbody>
    </table>
    <div class="col-sm-2 col-sm-offset-3">
        <button class="btn btn-block btn-default self-save" ${overtime?then("", "disabled")} title="${overtime?then( "保存","已超过截至日期")}" type="button" data-department="217">保存</button>
    </div>
    <div class="col-sm-2 col-sm-offset-2">
        <button class="btn btn-block btn-primary self-submit" ${overtime?then("", "disabled")} title="${overtime?then( "提交","已超过截至日期")}" type="button" data-department="217">提交</button>
    </div>
</div>
