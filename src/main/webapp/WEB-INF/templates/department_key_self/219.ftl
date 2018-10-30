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
        <tr data-task="124">
            <td rowspan="4" class="radio-oneline rowspan">
                <div class="radio">
                    <label>
                        <input type="radio" name="finish_124" value="true">
                        已完成
                    </label>
                </div>
                <div class="radio">
                    <label class="text-danger">
                        <input type="radio" name="finish_124" value="false">
                        未完成
                    </label>
                </div>
            </td>
            <td rowspan="4" class="exclusion rowspan">
                <input type="text" class="form-control" data-validate data-max="100" data-min="0" data-validate data-max="100" name="score_124">
            </td>
            <td rowspan="4" class="rowspan">
                <textarea class="form-control" name="comment_124"></textarea>
            </td>
            <td rowspan="4" class="rowspan">图书馆人文空间改造建设项目</td>
            <td>
                <p>3~4月：完成项目的调研工作</p>
            </td>
            <td>
                <p>完成调研报告</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>5~6月：完成项目的初步设计方案</p>
            </td>
            <td>
                <p>项目的初步设计方案书</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>9~10月：完成项目设计方案的论证</p>
            </td>
            <td>
                <p>项目设计方案论证会会议纪要</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>11~12月：开始启动项目建设</p>
            </td>
            <td>
                <p>项目建设启动相关文件</p>
            </td>
        </tr>
        <tr data-task="125">
            <td rowspan="2" class="radio-oneline rowspan">
                <div class="radio">
                    <label>
                        <input type="radio" name="finish_125" value="true">
                        已完成
                    </label>
                </div>
                <div class="radio">
                    <label class="text-danger">
                        <input type="radio" name="finish_125" value="false">
                        未完成
                    </label>
                </div>
            </td>
            <td rowspan="2" class="exclusion rowspan">
                <input type="text" class="form-control" data-validate data-max="100" data-min="0" data-validate data-max="100" name="score_125">
            </td>
            <td rowspan="2" class="rowspan">
                <textarea class="form-control" name="comment_125"></textarea>
            </td>
            <td rowspan="2" class="rowspan">举办第十三届读书节系列活动</td>
            <td>
                <p>4月: （1）精品图书进校园活动（2）学生辩论赛1次（3）专家读书讲座1次</p>
            </td>
            <td rowspan="2" class="rowspan">
                <p>活动相关资料</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>5月：（4）“爱心赠书行”公益活动1次（5）读书征文比赛1次</p>
            </td>
        </tr>

        <tr data-task="126">
            <td rowspan="2" class="radio-oneline rowspan">
                <div class="radio">
                    <label>
                        <input type="radio" name="finish_126" value="true">
                        已完成
                    </label>
                </div>
                <div class="radio">
                    <label class="text-danger">
                        <input type="radio" name="finish_126" value="false">
                        未完成
                    </label>
                </div>
            </td>
            <td rowspan="2" class="exclusion rowspan">
                <input type="text" class="form-control" data-validate data-max="100" data-min="0" data-validate data-max="100" name="score_126">
            </td>
            <td rowspan="2" class="rowspan">
                <textarea class="form-control" name="comment_126"></textarea>
            </td>
            <td rowspan="2" class="rowspan">按时保质保量完成年度图书采购、验收与入库任务。</td>
            <td>
                <p>2-7月：完成1.5万册</p>
            </td>
            <td rowspan="2" class="rowspan">
                <p>本年度购置新书2.5万册（全年），完成新书采访、编目、加工工作。</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>9-12月：完成1万册</p>
            </td>
        </tr>
        <tr data-task="127">
            <td rowspan="3" class="radio-oneline rowspan">
                <div class="radio">
                    <label>
                        <input type="radio" name="finish_127" value="true">
                        已完成
                    </label>
                </div>
                <div class="radio">
                    <label class="text-danger">
                        <input type="radio" name="finish_127" value="false">
                        未完成
                    </label>
                </div>
            </td>
            <td rowspan="3" class="exclusion rowspan">
                <input type="text" class="form-control" data-validate data-max="100" data-min="0" data-validate data-max="100" name="score_127">
            </td>
            <td rowspan="3" class="rowspan">
                <textarea class="form-control" name="comment_127"></textarea>
            </td>
            <td rowspan="3" class="rowspan">举办 “数字资源推广”系列活动</td>
            <td>
                <p>3-7月：完成讲座5场次</p>
            </td>
            <td rowspan="3" class="rowspan">
                <p>(1)开设数字资源讲座相关资料（2）举办年度个人优秀教工读者评选活动的相关资料。</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>9-12月：完成讲座5场次</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>11月：举办优秀读者评选活动</p>
            </td>
        </tr>

        </tbody>
    </table>
    <div class="col-sm-2 col-sm-offset-3">
        <button class="btn btn-block btn-default self-save" ${overtime?then("", "disabled")} title="${overtime?then( "保存","已超过截至日期")}" type="button" data-department="219">保存</button>
    </div>
    <div class="col-sm-2 col-sm-offset-2">
        <button class="btn btn-block btn-primary self-submit" ${overtime?then("", "disabled")} title="${overtime?then( "提交","已超过截至日期")}" type="button" data-department="219">提交</button>
    </div>
</div>
