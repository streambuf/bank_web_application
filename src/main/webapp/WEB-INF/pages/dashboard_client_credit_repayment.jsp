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
                            Погашение кредита
                        </h3>
                    </div><!-- /.box-header -->
                    <!-- form start -->
                    <form role="form" class="operation" action="/dashboard/client/credit-repayment/send">
                        <div class="box-body">


                            <!-- select -->
                            <div class="form-group">
                                <label>Выберите кредит</label>
                                <div class = "error"></div>
                                <input type="hidden" name="creditError"/>
                                <select class="form-control" id="creditId" name="creditId">
                                    <option disabled selected>Выберите свой кредит для погашения</option>
                                    <c:forEach items="${credits}" var="credit">
                                            <option value="${credit.id}">Кредит на сумму ${credit.quantityOfMoney}</option>
                                    </c:forEach>
                                </select>

                            </div>

                            <!-- select -->
                            <div class="form-group">
                                <label>Выберите счет</label>
                                <div class = "error"></div>
                                <input type="hidden" name="accountError"/>
                                <select class="form-control" name="accountId">
                                    <option disabled selected>Выберите свой счет для оплаты</option>
                                    <c:forEach items="${user.accounts}" var="account">
                                        <option value="${account.id}">${account.id} ${account.currency}</option>
                                    </c:forEach>
                                </select>

                            </div>

                            <div class="form-group">
                                <label for="quantityOfMoney">Сумма к оплате</label>
                                <div class = "error"></div>
                                <input type="number" step="0.01" class="form-control" id="quantityOfMoney" min="-9223372036854775807" max="9223372036854775807" name="quantityOfMoney"  value="4324.43" readonly="true" />
                            </div>



                            <div class="callout callout-success hidediv">
                                <h4></h4>
                                <p></p>
                            </div>

                        </div><!-- /.box-body -->


                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Оплатить</button>
                        </div>
                    </form>

                </div><!-- /.box -->
            </div>
        </div>
    </section><!-- /.content -->
</div><!-- /.content-wrapper -->


<!-- add class .active for li[num] in sidebar-menu -->
<input id="meta.page.li.num" type="hidden" value="6" />
<input id="meta.page.tree.li.num" type="hidden" value="1" />
<c:forEach items="${credits}" var="credit">
    <input type="hidden" id="${credit.id}" value="${credit.monthlyPayment}" />
</c:forEach>
</body>

<div id="javascript">
<script>
    $(function(){
        $("#creditId").change(function() {
            var inputId = $(this).val();
            var monthlyRepayment = $("#" + inputId).val();
            $("#quantityOfMoney").val(monthlyRepayment);
        }).change();
    });
</script>
</div>

</html>

