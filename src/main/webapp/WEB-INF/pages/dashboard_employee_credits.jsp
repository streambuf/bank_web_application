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
                Оформление кредитов
                <small></small>
            </h1>

        </section>

        <!-- Main content -->
        <section class="content">
            <!-- Small boxes (Stat box) -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Неподтвержденные заявки на кредит</h3>
                            <div class="box-tools">
                                <div class="input-group">
                                    <input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 350px;" placeholder="Поиск"/>
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div><!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <tr>
                                    <th>Идентификатор кредита</th>
                                    <th>ФИО клиента</th>
                                    <th>Сумма</th>
                                    <th>Ставка</th>
                                    <th>Срок (мес.)</th>
                                    <th>Платеж в мес.</th>
                                    <th style="width: 10px">Подтверждение</th>
                                    <th style="width: 10px">Удаление</th>
                                </tr>
                                <c:forEach items="${credits}" var="credit">
                                    <tr>
                                        <td>${credit.id}</td>
                                        <td>${credit.account.user.lname} ${credit.account.user.fname} ${credit.account.user.patronymic}</td>
                                        <td>${credit.quantityOfMoney} руб.</td>
                                        <td>${credit.annualPercentageRate} %</td>
                                        <td>${credit.period}</td>
                                        <td>${credit.monthlyPayment} руб.</td>
                                        <td>
                                            <a class="confirm btn btn-block btn-success" href="/dashboard/employee/credit/${credit.id}"><i class="fa plus-square"></i></a>
                                        </td>
                                        <td>
                                            <form role="form" class="delete" action="/dashboard/employee/credit/delete">
                                                <input type="hidden" name="longParam" value="${credit.id}"/>

                                                <button type="submit" class="delete btn btn-block btn-danger">
                                                    <i class="fa fa-minus-square"></i>
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div>
            </div><!-- /.row -->



        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <!-- add class .active for li[num] in sidebar-menu -->
    <input id="meta.page.li.num" type="hidden" value="3" />
</body>

<div id="javascript">

</div>

</html>