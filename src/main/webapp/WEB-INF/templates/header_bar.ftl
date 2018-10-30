<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">常州信息职业技术学院绩效考核系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
            <#if employee??>
                <li>
                    <a data-emp="${employee.empId}" id="employee" href="javascript:void(0);">${ employee.name }</a>
                </li>
                <li class="separated"></li>
                <li><a href="${ctx}/logout">退出登录</a></li>
            <#else>
                <li><a href="${ctx}/login">登录</a></li>
            </#if>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>