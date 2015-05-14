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


    <!-- Main content -->
    <section class="content">
        <div class="row">
            <!-- left column -->
            <div class="col-md-6">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title">Обмен валюты</h3>
                    </div><!-- /.box-header -->
                    <!-- form start -->
                    <form role="form" class="operation" action="/dashboard/client/currency-exchange/send">
                        <div class="box-body">
                            <!-- select -->
                            <div class="form-group">
                                <label>Продать со счета</label>
                                <div class = "error"></div>
                                <input type="hidden" name="accountSenderError"/>
                                <select class="form-control" name="accountSenderId">
                                    <option disabled selected>Выберите свой счет</option>
                                    <c:forEach items="${user.accounts}" var="account">
                                        <option value="${account.id}">${account.id} ${account.currency}</option>
                                    </c:forEach>
                                </select>
                            </div>


                            <div class="form-group">
                                <label>Получить на счет</label>
                                <div class = "error"></div>
                                <input type="hidden" name="accountPayeeError"/>
                                <select class="form-control" name="accountPayeeId">
                                    <option disabled selected>Выберите свой счет</option>
                                    <c:forEach items="${user.accounts}" var="account">
                                        <option value="${account.id}">${account.id} ${account.currency}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="quantityOfMoney">Сумма</label>
                                <div class = "error"></div>
                                <input type="number" step="0.01" class="form-control" id="quantityOfMoney" min="-9223372036854775807" max="9223372036854775807" name="quantityOfMoney" placeholder="Введит сумму">
                            </div>

                            <div class="callout callout-success hidediv">
                                <h4></h4>
                                <p></p>
                            </div>

                        </div><!-- /.box-body -->


                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Обменять</button>
                        </div>
                    </form>

                </div><!-- /.box -->
            </div>
        </div>
    </section><!-- /.content -->
</div><!-- /.content-wrapper -->


<!-- add class .active for li[num] in sidebar-menu -->
<input id="meta.page.li.num" type="hidden" value="4" />

</body>

</html>