<div class="tab-pane" id="result-department">
    <h2 class="page-header">${employee.department.shortName}绩效考核结果</h2>

    <div>
        <div class="table-responsive" id="print">
            <h2 class="print-title">2017年常州信息职业技术学院绩效考核结果</h2>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th>考核项</th>
                    <th>得分</th>
                </tr>
                </thead>
                <tbody id="result-box" data-department="${employee.department.id}">

                </tbody>
            </table>
            <div class="col-sm-2 pull-right">
                <button class="btn btn-block btn-default no-print" type="button" id="print-preview">打印</button>
            </div>

            <footer>
                <h5 class="print-footer pull-right">${employee.department.shortName}</h5>
            </footer>
        </div>
    </div>

    <div class="modal fade" id="detail">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                    <h4 class="modal-title">评分详情</h4>
                </div>
                <div class="modal-body" id="detail-body">

                </div>
            </div>
        </div>
    </div>
</div>
