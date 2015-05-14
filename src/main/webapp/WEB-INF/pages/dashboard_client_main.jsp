<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>
        <spring:message code="application.name"/>
    </title>
</head>
<body>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Счета
                <small>Информация по вашим счетам</small>
            </h1>

        </section>

        <!-- Main content -->
        <section class="content">
            <!-- Small boxes (Stat box) -->
            <div class="row">
                <c:forEach items="${user.accounts}" var="account">
                    <c:choose>
                        <c:when test="${account.currency=='RUBLE'}">
                            <div class="col-lg-4 col-xs-6">
                                <!-- small box -->
                                <div class="small-box bg-aqua">
                                    <div class="inner">
                                        <h3>${account.balance} <i class="fa fa-rub"></i></h3>
                                        <p>Номер счета: ${account.id}</p>
                                    </div>
                                    <div class="icon">
                                        <i class="fa fa-rub"></i>
                                    </div>
                                    <a href="#" class="small-box-footer">Подробнее <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div><!-- ./col -->
                        </c:when>
                        <c:when test="${account.currency=='DOLLAR'}">
                            <div class="col-lg-4 col-xs-6">
                                <!-- small box -->
                                <div class="small-box bg-green">
                                    <div class="inner">
                                        <h3>${account.balance} $</h3>
                                        <p>Номер счета: ${account.id}</p>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-social-usd"></i>
                                    </div>
                                    <a href="#" class="small-box-footer">Подробнее <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div><!-- ./col -->
                        </c:when>
                        <c:when test="${account.currency=='EUROS'}">
                            <div class="col-lg-4 col-xs-6">
                                <!-- small box -->
                                <div class="small-box bg-yellow">
                                    <div class="inner">
                                        <h3>${account.balance} €</h3>
                                        <p>Номер счета: ${account.id}</p>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-social-euro"></i>
                                    </div>
                                    <a href="#" class="small-box-footer">Подробнее <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div><!-- ./col -->
                        </c:when>
                    </c:choose>

                </c:forEach>
            </div><!-- /.row -->

            <div class="row">
                <div class="content-header">
                    <h1>Оплата покупок и услуг</h1>

                </div>

                <c:forEach items="${categoryServices}" var="categoryService">
                    <div class="col-lg-3 col-xs-6">

                        <h4 class="category"> <img src="/resources/img/category_service/${categoryService.logotype}" alt="category"/>  <strong>${categoryService.name}</strong></h4>
                        <ul>
                            <c:forEach items="${categoryService.services}" var="service">
                                <li>
                                   <a href="/dashboard/client/service/${service.id}" class="service"><i class="fa fa-circle-o"></i> ${service.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div><!-- ./col -->
                </c:forEach>

            </div><!-- /.row -->

        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <!-- add class .active for li[num] in sidebar-menu -->
    <input id="meta.page.li.num" type="hidden" value="1" />
</body>

<div id="javascript">

</div>

</html>