<div class="tab-pane" id="result-exception">
    <h2 class="page-header">结果公示</h2>
    <div>
        <div class="table-responsive print-condensed" id="exception-print">
            <h2 class="print-title">2017年常州信息职业技术学院绩效考核结果</h2>
            <table class="table table-striped table-hover table-bordered table-condensed">
                <thead>
                <tr>
                    <th rowspan="3" class="rowspan">职能部门</th>
                    <th colspan="2">突出贡献</th>
                    <th colspan="6">严重失误</th>
                </tr>
                <tr>
                    <th>重大贡献</th>
                    <th>奖励表彰</th>
                    <th>工作失误</th>
                    <th>工作作风</th>
                    <th>师德师风</th>
                    <th>党风廉政</th>
                    <th>审计问题</th>
                    <th>安全问题</th>
                </tr>
                <tr>
                    <th>考核小组</th>
                    <th>考核小组</th>
                    <th>党办院办</th>
                    <th>考核小组</th>
                    <th>人力资源</th>
                    <th>纪委办</th>
                    <th>审计处</th>
                    <th>保卫处</th>
                </tr>
                <tr>
                    <th></th>
                    <th>0-10</th>
                    <th>0-10</th>
                    <th>-10-0</th>
                    <th>-10-0</th>
                    <th>-10-0</th>
                    <th>-10-0</th>
                    <th>-10-0</th>
                    <th>-10-0</th>
                </tr>
                </thead>
                <tbody id="exception-box">
                <#list departments as department>
                <tr data-department="${department.id}">
                    <td>${department.shortName}</td>
                    <td data-first="1" data-second="1">未评分</td>
                    <td data-first="1" data-second="2">未评分</td>
                    <td data-first="2" data-second="1">未评分</td>
                    <td data-first="2" data-second="2">未评分</td>
                    <td data-first="2" data-second="3">未评分</td>
                    <td data-first="2" data-second="4">未评分</td>
                    <td data-first="2" data-second="5">未评分</td>
                    <td data-first="2" data-second="6">未评分</td>
                </tr>
                </#list>
                </tbody>
            </table>
            <div class="col-sm-2 pull-right">
                <button class="btn btn-block btn-default no-print" type="button" id="exception-preview">打印</button>
            </div>

            <footer>
                <h5 class="print-footer pull-right">常州信息职业技术学院</h5>
            </footer>
        </div>
    </div>
</div>