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
                Подтверждение кредита
            </h1>

        </section>

        <!-- Main content -->
        <section class="content">
            <!-- Small boxes (Stat box) -->
            <div class="row">
                <div class="col-md-6">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">
                                Данные по кредиту
                            </h3>
                        </div><!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" class="operation" action="/dashboard/employee/credit/confirm/send">
                            <div class="box-body">

                                    <div class="box-body table-responsive no-padding">
                                        <table class="table table-hover table-striped">
                                            <tr><td>Идентификатор</td><td>${credit.id}</td></tr>
                                            <tr><td>Сумма кредита</td><td>${credit.quantityOfMoney} руб.</td></tr>
                                            <tr><td>Процентная ставка</td><td>${credit.annualPercentageRate} %</td></tr>
                                            <tr><td>Дата заявки</td><td>${credit.startDate}</td></tr>
                                            <tr><td>Срок</td><td>${credit.period} мес.</td></tr>
                                            <tr><td>Ежемесячный платеж</td><td>${credit.monthlyPayment} руб.</td></tr>
                                            <tr><td>Счет</td><td>${credit.account.id}</td></tr>
                                            <tr><td>ФИО</td><td>${credit.account.user.lname} ${credit.account.user.fname} ${credit.account.user.patronymic}</td></tr>
                                            <tr><td>Серия и номер паспорта</td><td>${credit.account.user.passport.series} ${credit.account.user.passport.num}</td></tr>
                                            <tr><td>Место работы</td><td>${credit.placeOfWork}</td></tr>
                                            <tr><td>Заработная плата</td><td>${credit.salary} руб.</td></tr>
                                        </table>
                                    </div><!-- /.box-body -->

                                <input type="hidden" name="longParam" value="${credit.id}" />

                                <div class="callout callout-success hidediv">
                                    <h4></h4>
                                    <p></p>
                                    <a href="/dashboard/employee/credits" class="btn btn-primary">Назад</a>
                                </div>

                            </div><!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Подтвердить</button>
                            </div>
                        </form>

                    </div><!-- /.box -->
                </div>
            </div><!-- /.row -->



        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <!-- add class .active for li[num] in sidebar-menu -->
    <input id="meta.page.li.num" type="hidden" value="2" />
</body>

<div id="javascript">

</div>

</html>