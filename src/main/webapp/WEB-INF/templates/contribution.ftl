<div class="tab-pane" id="contribution">
    <h2 class="page-header">重大贡献</h2>

    <div class="well department-annotations">
        <p><span class="text-danger">注：</span>赋分方法</p>
        <p>重大贡献:依据部门工作对学院发展的重大贡献要素，由考核小组集体评议拟定赋分分值。</p>
        <p>奖励表彰:</p>
        <p>
            1.奖励表彰分值：国家级至多加3分（独立完成最高3分、合作完成最高2分、汇总申报最高1分），省级至多加2分（独立完成最高2分、合作完成最高1分、汇总申报最高0.5分），市级至多加1分（独立完成最高1分、合作完成最高0.5分、汇总申报最高0.25分），其他突出表现，酌情加分。</p>
        <p>2.仅计算部门获得的奖励表彰，个人荣誉除外；</p>
        <p>3.同一事件获多项相同级别或不同级别的荣誉，就高得分，不累计算分。</p>
        <p>4.级别的认定，以颁发奖励证书的签章政府部门级别为准，同级别的协会、学会等非政府部门颁发的奖励降一级赋分。</p>
    </div>
    <form>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>职能部门</th>
                    <th>贡献类型</th>
                    <th>自评分</th>
                    <th>自评说明</th>
                    <th>佐证材料</th>
                    <th>赋分</th>
                    <th>赋分说明</th>
                </tr>
                </thead>
                <tbody>
                <#list irregular?keys as item>
                    <#list irregular[item]['contributions'] as contribution>
                    <tr data-department="${item}" data-second="1" data-element="${contribution?counter}">
                        <#if contribution?counter == 1>
                            <td rowspan="${irregular[item]['contributions']?size + irregular[item]['commendations']?size}"
                                class="rowspan">${irregular[item]['shortName']}</td>
                            <td rowspan="${irregular[item]['contributions']?size}" class="rowspan">重大贡献</td>
                        </#if>
                        <td><p>${contribution.score!"未填写"}</p></td>
                        <td><p>${contribution.comment}</p></td>
                        <td>
                            <#if contribution.evidenceFile?length != 0>
                                <a href="${ctx}/download/${contribution.evidenceFile}">下载</a>
                            <#else>
                                <a href="#file" data-toggle="modal">下载</a>
                            </#if>
                        </td>
                        <td class="exclusion">
                            <input type="text" class="form-control" name="score" data-validate data-max="10"
                                   data-min="0">
                        </td>
                        <td>
                            <textarea class="form-control" name="comment"></textarea>
                        </td>
                    </tr>
                    </#list>
                    <#list irregular[item]['commendations'] as commendation>
                    <tr data-department="${item}" data-second="2" data-element="${commendation?counter}">
                        <#if commendation?counter == 1>
                            <#if irregular[item]['contributions']?size == 0>
                                <td rowspan="${irregular[item]['commendations']?size}" class="rowspan">${irregular[item]['shortName']}</td>
                            </#if>
                            <td rowspan="${irregular[item]['commendations']?size}" class="rowspan">奖励表彰</td>
                        </#if>
                        <td><p>${commendation.score!"未填写"}</p></td>
                        <td><p>${commendation.comment}</p></td>
                        <td>
                            <#if commendation.evidenceFile?length != 0>
                                <a href="${ctx}/download/${commendation.evidenceFile}">下载</a>
                            <#else>
                                <a href="#file" data-toggle="modal">下载</a>
                            </#if>
                        </td>
                        <td class="exclusion">
                            <input type="text" class="form-control" name="score" data-validate data-max="3"
                                   data-min="0">
                        </td>
                        <td>
                            <textarea class="form-control" name="comment"></textarea>
                        </td>
                    </tr>
                    </#list>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col-sm-2 col-sm-offset-3">
            <button class="btn btn-block btn-default contribution_save" ${overtime?then("", "disabled")} title="${overtime?then("保存", "已超过截至日期")}" type="button">保存</button>
        </div>
        <div class="col-sm-2 col-sm-offset-3">
            <button class="btn btn-block btn-primary contribution_btn" ${overtime?then("", "disabled")} title="${overtime?then("提交", "已超过截至日期")}" type="button">提交</button>
        </div>
    </form>

    <div class="modal fade" id="file" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">友情提示</h4>
                </div>
                <div class="modal-body">
                    <div class="alert alert-warning" role="alert">
                        <p>该项未上传佐证材料！</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>