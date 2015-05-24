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
                Создание счета
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
                                Данные по клиенту
                            </h3>
                        </div><!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" class="operation" action="/dashboard/employee/account/create/send">
                            <div class="box-body">


                                <div class="box-body table-responsive no-padding">
                                    <table class="table table-hover table-striped">
                                        <tr><td>Идентификатор</td><td>${client.id}</td></tr>
                                        <tr><td>Фамилия</td><td>${client.lname}</td></tr>
                                        <tr><td>Имя</td><td>${client.fname}</td></tr>
                                        <tr><td>Отчество</td><td>${client.patronymic}</td></tr>
                                        <tr><td>Дата рождения</td><td>${client.dateOfBirth}</td></tr>
                                        <tr><td>ИНН</td><td>${client.tin}</td></tr>
                                        <tr><td>Email</td><td>${client.email}</td></tr>
                                        <tr><td>Гражданство</td><td>${client.citizenship}</td></tr>
                                        <tr><td>Адрес</td><td>${client.address}</td></tr>
                                        <tr><td>Телефон</td><td>${client.phone}</td></tr>
                                    </table>
                                </div><!-- /.box -->
                                </br> </br>
                                <!-- select -->
                                <div class="form-group">
                                    <label>Выберите валюту счета</label>
                                    <div class = "error"></div>
                                    <input type="hidden" name="accountError"/>
                                    <select class="form-control" name="currency">
                                        <option disabled selected>Выберите валюту</option>
                                        <option value="RUBLE">рубль</option>
                                        <option value="DOLLAR">доллар</option>
                                        <option value="EUROS">евро</option>
                                    </select>
                                </div>

                                <input type="hidden" name="userId" value="${client.id}" />

                                <div class="callout callout-success hidediv">
                                    <h4></h4>
                                    <p></p>
                                    <a href="/dashboard/employee/clients-account" class="btn btn-primary">Назад</a>
                                </div>

                            </div><!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Создать счет</button>
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