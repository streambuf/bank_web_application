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
                Работа с пользователями
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
                            <h3 class="box-title">Пользователи</h3>
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
                                    <th>Идентификатор</th>
                                    <th>Фамилия</th>
                                    <th>Имя</th>
                                    <th>Отчество</th>
                                    <th>Роль</th>
                                    <th style="width: 143px">Дать права сотрудника</th>
                                    <th style="width: 143px">Удаление</th>
                                </tr>
                                <c:forEach items="${users}" var="user">
                                    <tr>
                                        <td>${user.id}</td>
                                        <td>${user.lname}</td>
                                        <td>${user.fname}</td>
                                        <td>${user.patronymic}</td>

                                        <c:if test="${empty user.userRoles}">
                                            <td><span class="badge bg-gray">Нет</span></td>
                                        </c:if>
                                        <c:forEach items="${user.userRoles}" var="role">
                                            <c:choose>
                                                <c:when test="${role.listRole=='ROLE_CLIENT'}">
                                                    <td><span class="badge bg-green">Клиент</span></td>
                                                </c:when>
                                                <c:when test="${role.listRole=='ROLE_EMPLOYEE'}">
                                                    <td><span class="badge bg-yellow">Сотрудник</span></td>
                                                </c:when>
                                                <c:when test="${role.listRole=='ROLE_ADMIN'}">
                                                    <td><span class="badge bg-red">Админ</span></td>
                                                </c:when>
                                            </c:choose>
                                        </c:forEach>


                                        
                                        <td>
                                            <form role="form" class="add-role-employee" action="/dashboard/admin/user/add-role-employee/${user.id}">
                                                <button class="confirm btn btn-block btn-success"

                                                    <c:forEach items="${user.userRoles}" var="role">
                                                        <c:choose>
                                                            <c:when test="${role.listRole=='ROLE_CLIENT'}">
                                                                disabled
                                                            </c:when>
                                                            <c:when test="${role.listRole=='ROLE_EMPLOYEE'}">
                                                                disabled
                                                            </c:when>
                                                            <c:when test="${role.listRole=='ROLE_ADMIN'}">
                                                                disabled
                                                            </c:when>
                                                        </c:choose>
                                                    </c:forEach>
                                                ><i class="fa fa-plus-square"></i></button>
                                            </form>
                                        </td>
                                        <td>
                                            <form role="form" class="delete" action="/dashboard/admin/user/delete/${user.id}">
                                                <input type="hidden" name="longParam" value="${user.id}"/>



                                                <button type="submit" class="delete btn btn-block btn-danger"
                                                        <c:forEach items="${user.userRoles}" var="role">
                                                            <c:if test="${role.listRole=='ROLE_ADMIN'}">
                                                                disabled
                                                            </c:if>
                                                        </c:forEach>
                                                        >


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
    <input id="meta.page.li.num" type="hidden" value="2" />
</body>

<div id="javascript">

</div>

</html>