<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="/resources/css/icheck-blue.css" rel="stylesheet" type="text/css" />
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
                                <select class="form-control" name="accountId" id="accountId">
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
                                <label for="period">На срок (от 1 до 36 месяцев)</label>
                                <div class = "error"></div>
                                <input type="number" step="1" min="1" max="36" class="form-control" id="period" name="period" />
                            </div>

                            <div class="form-group">
                                <label for="contributionRate">Процентная ставка (%)</label>
                                <input type="text" class="form-control" id="contributionRate"disabled/>
                            </div>

                            <div class="form-group">
                                <label>Порядок уплаты прцоентов</label>
                                <div class = "error"></div>

                                <p><input type="radio" value="TRANSFER" name="listPaymentProcedure"> перечисление процентов на счет банковской карты</p>
                                <p><input type="radio" value="CAPITALIZATION" name="listPaymentProcedure" checked> капитализация процентов на счете по вкладу</p>
                            </div>


                            <div class="callout callout-success hidediv">
                                <h4></h4>
                                <p></p>
                            </div>

                        </div><!-- /.box-body -->


                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Оформить вклад</button>
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

<c:forEach items="${user.accounts}" var="account">
    <input style="display: none" type="hidden" id="${account.id}" value="${account.currency}" />
</c:forEach>
</body>

<div id="javascript">
    <script src="/resources/js/icheck.min.js"></script>
    <script>
        $(document).ready(function(){
            $('input').iCheck({
                checkboxClass: 'icheckbox_square-blue',
                radioClass: 'iradio_square-blue',
                increaseArea: '20%' // optional
            });

            var money = null, period = null, currency = null;
            chooseRate(money, period, currency);

            $("#accountId").change(function() {
                var inputId = $(this).val();
                currency = $("#" + inputId).val();
                if (typeof currency == 'undefined') {
                    currency = null;
                }
            }).change();



            $("#quantityOfMoney").bind("change paste", function() {
                money = $(this).text();
                chooseRate(money, period);
            });

            $("#period").bind("change paste", function() {
                period = $(this).val();
                chooseRate(money, period);
            });




        });

        function chooseRate(money, period, currency) {
            var locator = "#contributionRate";
            if (!money && !period && !currency) {
                $(locator).val("Для отображениии ставки необходимо указать счет, сумму и срок");
            } else {
                getContributionRate();
            }
        }

        function getContributionRate() {
            var locator = ".operation";
            var oldAction = $(locator).attr('action');
            $(locator).get(0).setAttribute('action', '/dashboard/client/contribution-rate/get');
            console.log($(locator).attr('action'));
            sendPost($(locator),
                    function(result) {
                        console.log("OK");
                        var locator = "#contributionRate";
                        $(locator).val(result.data.rate);
                    },
                    function(result) {
                        console.log("error");
                        showError(result.data);
                    }
            );
            $(locator).get(0).setAttribute('action', oldAction);

        }


    </script>
</div>



</html>

