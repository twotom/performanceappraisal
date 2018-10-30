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
        <tr data-task="111">
            <td rowspan="4" class="radio-oneline rowspan">
                <div class="radio">
                    <label>
                        <input type="radio" name="finish_111" value="true">
                        已完成
                    </label>
                </div>
                <div class="radio">
                    <label class="text-danger">
                        <input type="radio" name="finish_111" value="false">
                        未完成
                    </label>
                </div>
            </td>
            <td rowspan="4" class="exclusion rowspan">
                <input type="text" class="form-control" data-validate data-max="100" data-min="0" data-validate data-max="100" name="score_111">
            </td>
            <td rowspan="4" class="rowspan">
                <textarea class="form-control" name="comment_111"></textarea>
            </td>
            <td rowspan="4" class="rowspan">20-1-1.提高学院预算编制精准性.<br>
                20-1-2.加强院内部门预算编制的指导、审核与执行监督.<br>
                20-1-3.探索建立预算绩效管理和全程监控机制.
            </td>
            <td>
                <p>3月：认真完成按时做好学院预算编制上报工作，预算正确率达90%。指导完成院内各部门预算编制任务并通过审核确定。</p>
            </td>
            <td rowspan="4">
                <p>1、学院预算编制准确率需达90%以上；<br>
                    2、指导、审核完成学院内部部门预算编制工作。<br>
                    3、对学院内部部门预算实行全方位的监督、监控，建立绩效考核机制。
                </p>
            </td>
        </tr>
        <tr>
            <td>
                <p>4月：完成下达院内部门预算数。</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>5-12月：监督检查各部门预算执行情况。</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>5-12月：建立预算绩效考核和监控机制、制度。</p>
            </td>
        </tr>
        <tr data-task="112">
            <td rowspan="4" class="radio-oneline rowspan">
                <div class="radio">
                    <label>
                        <input type="radio" name="finish_112" value="true">
                        已完成
                    </label>
                </div>
                <div class="radio">
                    <label class="text-danger">
                        <input type="radio" name="finish_112" value="false">
                        未完成
                    </label>
                </div>
            </td>
            <td rowspan="4" class="exclusion rowspan">
                <input type="text" class="form-control" data-validate data-max="100" data-min="0" data-validate data-max="100" name="score_112">
            </td>
            <td rowspan="4" class="rowspan">
                <textarea class="form-control" name="comment_112"></textarea>
            </td>
            <td>20-2-1.启动内部控制制度体系建设</td>
            <td>
                <p>3-4月：评价学院内部控制风险点。<br>
                    5-6月：修订完善内部控制制度和流程。<br>
                    7-9月：部分内部控制信息化。<br>
                    10-12月：初步形成内部控制体系。
                </p>
            </td>
            <td>
                <p>2017年初步形成学院内部控制业务流程和手册。</p>
            </td>
        </tr>
        <tr>
            <td rowspan="2">
                <p>20-2-2.修订和完善劳务费管理办法</p>
            </td>
            <td>
                <p>3-4月：疏理目前学院各劳务费发放的种类。</p>
            </td>
            <td rowspan="2">
                <p>制定出台学院新的劳务费管理办法。</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>5-6月：完成出台修订和完善后的劳务费管理办法。</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>20-2-3.提升财务活动的规范化、系统化、流程化水平</p>
            </td>
            <td>
                <p>3-4月：疏理目前财务活动中在规范化、系统化、流程化上存在的缺陷。
                    5-6月：规范财务审批报销制度。<br>
                    7-9月：制订财务活动流程图。<br>
                    10-12月：建立健全全院财务审批报销活动的系统化。
                </p>
            </td>
            <td>
                <p>制定出台新的财务审批报销管理制度。</p>
            </td>
        </tr>


        </tbody>
    </table>
    <div class="col-sm-2 col-sm-offset-3">
        <button class="btn btn-block btn-default self-save" ${overtime?then("", "disabled")} title="${overtime?then( "保存","已超过截至日期")}" type="button" data-department="216">保存</button>
    </div>
    <div class="col-sm-2 col-sm-offset-2">
        <button class="btn btn-block btn-primary self-submit" ${overtime?then("", "disabled")} title="${overtime?then( "提交","已超过截至日期")}" type="button" data-department="216">提交</button>
    </div>
</div>
