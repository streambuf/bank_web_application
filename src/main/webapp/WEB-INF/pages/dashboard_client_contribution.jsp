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
                        <h3 class="box-title">
                            Открытие вклада
                        </h3>
                    </div><!-- /.box-header -->
                    <!-- form start -->
                    <form role="form" class="operation" action="/dashboard/client/contribution/send">
                        <div class="box-body">


                            <!-- select -->
                            <div class="form-group">
                                <label>Выберите свой счет</label>
                                <div class = "error"></div>
                                <input type="hidden" name="accountError"/>
                                <select class="form-control" name="accountId">
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


                            <div class="form-group">
                                <label for="period">На срок (в месяцах)</label>
                                <div class = "error"></div>
                                <input type="number" step="1" min="-9223372036854775807" max="9223372036854775807" class="form-control" id="period" name="period" />
                            </div>

                            <div class="form-group">
                                <label for="annualPercentageRate">Процентная ставка (%)</label>
                                <input type="number" class="form-control" id="annualPercentageRate" value="20" disabled/>
                            </div>

                            <div class="form-group">
                                <label for="type">Тип платежа</label>
                                <input type="text" class="form-control" id="type" value="Аннуительный" disabled/>
                            </div>

                            <div class="form-group">
                                <label for="salary">Зарплата</label>
                                <div class = "error"></div>
                                <input type="number" step="0.01" class="form-control" min="-9223372036854775807" max="9223372036854775807" class="form-control" id="salary" name="salary" placeholder="Введит вашу зарплату"/>
                            </div>

                            <div class="form-group">
                                <label for="placeOfWork">Место работы</label>
                                <div class = "error"></div>
                                <input type="text" class="form-control" id="placeOfWork" name="placeOfWork" placeholder="Введит счет"/>
                            </div>


                            <div class="callout callout-success hidediv">
                                <h4></h4>
                                <p></p>
                            </div>

                        </div><!-- /.box-body -->


                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Оформить кредит</button>
                        </div>
                    </form>

                </div><!-- /.box -->
            </div>
            <div class="col-md-6">




                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">Таблица процентных ставок</h3>
                    </div><!-- /.box-header -->
                    <div class="box-body no-padding">
                        <table class="table table-striped" style="table-layout: fixed">
                            <tr>
                                <th>Валюта</th>
                                <th>Сумма</th>
                                <th>От 1 до 6 месяцев</th>
                                <th>От 6 месяцев до 1 года</th>
                                <th>От 1 года до 2 лет</th>
                                <th>От 2 лет до 3 лет</th>

                            </tr>
                            <c:forEach items="${table}" var="row">
                                <tr>
                                    <c:forEach items="${row}" var="cell">
                                        <td>${cell}</td>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                        </table>
                    </div><!-- /.box-body -->
                </div><!-- /.box -->

            </div>
        </div>
    </section><!-- /.content -->
</div><!-- /.content-wrapper -->


<!-- add class .active for li[num] in sidebar-menu -->
<input id="meta.page.li.num" type="hidden" value="5" />
<input id="meta.page.tree.li.num" type="hidden" value="0" />

</body>

</html>

