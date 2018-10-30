<div class="tab-pane" id="result-daily">
    <h2 class="page-header">结果汇总--工作规范</h2>
    <div>
        <div class="table-responsive" id="print">
            <h2 class="print-title">2017年常州信息职业技术学院绩效考核结果</h2>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th rowspan="3" class="rowspan">职能部门</th>
                    <th colspan="6">工作规范</th>
                </tr>
                <tr>
                    <th>工作计划和总结报送的及时性</th>
                    <th>工作台账规范性资料上交或部门归档</th>
                    <th>安全保卫</th>
                    <th>资产设备保管环境卫生</th>
                    <th>经费预决算及规范使用</th>
                </tr>
                <tr>
                    <th>党办院办</th>
                    <th>考核小组</th>
                    <th>保卫处</th>
                    <th>资后处</th>
                    <th>财务处</th>
                </tr>
                <tr>
                    <th></th>
                    <th>1</th>
                    <th>2</th>
                    <th>2.5</th>
                    <th>2.5</th>
                    <th>2</th>
                </tr>
                </thead>
                <tbody id="result-box">
                <#list departments as department>
                <tr data-department="${department.id}" data-indicator="2">
                    <td>${department.shortName}</td>
                    <td data-element="1">未评分</td>
                    <td data-element="2">未评分</td>
                    <td data-element="3">未评分</td>
                    <td data-element="4">未评分</td>
                    <td data-element="5">未评分</td>
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