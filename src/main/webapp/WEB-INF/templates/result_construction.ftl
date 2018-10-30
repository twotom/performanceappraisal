<div class="tab-pane" id="result-daily">
    <h2 class="page-header">结果汇总--作风建设</h2>
    <div>
        <div class="table-responsive" id="print">
            <h2 class="print-title">2017年常州信息职业技术学院绩效考核结果</h2>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th rowspan="3" class="rowspan">职能部门</th>
                    <th colspan="4">作风建设</th>
                </tr>
                <tr>
                    <th>宣传思想政治工作</th>
                    <th>队伍建设</th>
                    <th>廉政建设</th>
                    <th>制度建设</th>
                </tr>
                <tr>
                    <th>宣传部</th>
                    <th>人力资源</th>
                    <th>纪委办</th>
                    <th>发展规划</th>
                </tr>
                <tr>
                    <th></th>
                    <th>1</th>
                    <th>4</th>
                    <th>2</th>
                    <th>3</th>
                </tr>
                </thead>
                <tbody id="result-box">
                <#list departments as department>
                <tr data-department="${department.id}" data-indicator="1">
                    <td>${department.shortName}</td>
                    <td data-element="1">未评分</td>
                    <td data-element="2">未评分</td>
                    <td data-element="3">未评分</td>
                    <td data-element="4">未评分</td>
                </tr>
                </#list>
                </tbody>
            </table>
            <div class="col-sm-2 pull-right">
                <button class="btn btn-block btn-default no-print" type="button" id="print-preview">打印</button>
            </div>

            <footer>
                <h5 class="print-footer pull-right">常州信息职业技术学院</h5>
            </footer>
        </div>
    </div>
</div>