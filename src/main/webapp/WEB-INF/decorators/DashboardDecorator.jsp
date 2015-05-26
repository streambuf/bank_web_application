<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><sitemesh:write property='title'/></title>
    <sitemesh:write property='head'/>
    <sec:csrfMetaTags/>

    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="//code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="/resources/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />

    <link href="/resources/css/skin-blue.min.css" rel="stylesheet" type="text/css" />

    <link href="/resources/css/dashboard.css" rel="stylesheet" type="text/css" />
</head>

<body class="skin-blue">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href=
           <c:forEach items="${user.userRoles}" var="role">
           <c:choose>
           <c:when test="${role.listRole=='ROLE_CLIENT'}">
                   "/dashboard/client/main"
            </c:when>
            <c:when test="${role.listRole=='ROLE_EMPLOYEE'}">
                "/dashboard/employee/main"
            </c:when>
            <c:when test="${role.listRole=='ROLE_ADMIN'}">
                "/dashboard/admin/main"
            </c:when>
            </c:choose>
            </c:forEach>



           class="logo"><b>АИС</b> банк</a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Меню</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Notifications Menu -->
                    <li class="dropdown notifications-menu">
                        <!-- Menu toggle button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span class="label label-warning">1</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">1 уведомление</li>
                            <li>
                                <!-- Inner Menu: contains the notifications -->
                                <ul class="menu">
                                    <li><!-- start notification -->
                                        <a href="#">
                                            <i class="fa fa-users text-aqua"></i> Новое уведомление
                                        </a>
                                    </li><!-- end notification -->
                                </ul>
                            </li>
                            <li class="footer"><a href="#">Посмотреть все</a></li>
                        </ul>
                    </li>

                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                            <img src="/resources/img/avatars/${user.id}.png" class="user-image" alt="User Image"/>
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs">${user.lname} ${user.fname}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <img src="/resources/img/avatars/${user.id}.png" class="img-circle" alt="User Image" />
                                <p>
                                    ${user.lname} ${user.fname} ${user.patronymic}
                                    <small>${user.email}</small>
                                </p>
                            </li>

                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-right">
                                    <form action="/logout" method="post">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <input class="btn btn-default btn-flat" type="submit" value="Выход" />
                                    </form>

                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- Sidebar user panel (optional) -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="/resources/img/avatars/${user.id}.png" class="img-circle" alt="User Image" />
                </div>
                <div class="pull-left info">
                    <p> ${user.lname} ${user.fname}</p>
                    <!-- Status -->
                    <a href="#"><i class="fa fa-circle text-success"></i> В сети</a>
                </div>
            </div>

            <!-- search form (Optional) -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Поиск..."/>
              <span class="input-group-btn">
                <button type='submit' name='search' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
                </div>
            </form>
            <!-- /.search form -->

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu">
                <li class="header">Меню</li>
                <!-- Optionally, you can add icons to the links -->
                <security:authorize access="hasRole('ROLE_CLIENT')">
                    <li><a href="/dashboard/client/main"><span><i class="fa fa-home"></i> Главная</span></a></li>
                    <li><a href="/dashboard/client/transfer"><span><i class="fa fa-rub"></i> Перевод средств</span></a></li>
                    <li><a href="/dashboard/client/services"><span><i class="fa fa-cutlery"></i> Оплата услуг</span></a></li>
                    <li><a href="/dashboard/client/currency-exchange"><span><i class="fa fa-dollar"></i> Обмен валюты</span></a></li>
                    <li><a href="/dashboard/client/contribution"><i class="fa fa-money"></i> Открыть вклад</a></li>

                    <li class="treeview">
                        <a href="#"><span><i class="fa fa-sort-amount-asc"></i> Кредит</span> <i class="fa fa-angle-left pull-right"></i></a>
                        <ul class="treeview-menu">
                            <li><a href="/dashboard/client/credit"><i class="fa fa-circle-o"></i> Взять кредит</a></li>
                            <li><a href="/dashboard/client/credit-repayment"><i class="fa fa-circle-o"></i> Погасить кредит</a></li>
                        </ul>
                    </li>
                </security:authorize>
                <security:authorize access="hasRole('ROLE_EMPLOYEE')">
                    <li><a href="/dashboard/employee/main"><span><i class="fa fa-home"></i> Главная</span></a></li>
                    <li><a href="/dashboard/employee/clients"><span><i class="fa fa-edit"></i> Оформить клиента</span></a></li>
                    <li><a href="/dashboard/employee/credits"><span><i class="fa fa-book"></i> Разрешить кредит</span></a></li>
                    <li><a href="/dashboard/employee/clients-account"><span><i class="fa fa-money"></i> Создать счет</span></a></li>
                </security:authorize>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/dashboard/admin/main"><span><i class="fa fa-home"></i> Главная</span></a></li>
                    <li><a href="/dashboard/admin/users"><span><i class="fa fa-group"></i> Пользователи</span></a></li>
                </security:authorize>
            </ul><!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>


<sitemesh:write property='body'/>

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
            МГТУ им. Н.Э. Баумана
        </div>
        <!-- Default to the left -->
        <strong>&copy; 2015 <a href="https://github.com/streambuf/bank_web_application">АИС обслуживания клиентов банка</a> </strong> Дипломная работа Моисеева Максима
    </footer>

</div><!-- ./wrapper -->

<script src="/resources/js/jquery-2.1.4.min.js"></script>
<script src="/resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/resources/js/app.min.js" type="text/javascript"></script>
<script src="/resources/js/maskedinput.min.js"></script>
<script src="/resources/js/utils.js"></script>
<script src="/resources/js/server.js"></script>
<script src="/resources/js/dashboard.js"></script>



<sitemesh:write property='div.javascript' />

</body>
</html>