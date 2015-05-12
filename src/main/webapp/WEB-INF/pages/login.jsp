<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="/resources/css/login-form-reset.css">
    <link rel='stylesheet prefetch' href='http://daneden.github.io/animate.css/animate.min.css'>
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,400italic,700italic,700'>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="/resources/css/login-form.css">
    <title><spring:message code="application.title"/></title>
    <sec:csrfMetaTags/>
</head>
<body>
<div class='info'>
    <h1><spring:message code="application.name"/></h1>
</div>
<div class='form aniamted bounceIn'>
    <div class='switch'>
        <i class='fa fa-pencil fa-times'></i>
        <div class='tooltip'><spring:message code="loginform.registration"/></div>
    </div>
    <div class='login'>
        <h2><spring:message code="loginform.authentication"/></h2>
        <form:form action="login" method="post">
            <input placeholder='<spring:message code="loginform.id"/>' type='text' id="username" name="username"/>
            <input placeholder='<spring:message code="loginform.pass"/>' type='password' id="password" name="password"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button id="login"><spring:message code="loginform.login"/></button>
            <p style="color:red">
                <c:if test="${param.error == 'invalidLoginPassword'}">
                    <spring:message code="loginform.invalidLoginPassword"/>
                </c:if>
            </p>

            <p style="color:blue">
                <c:if test="${param.error == 'loginRequired'}">
                    <spring:message code="loginform.loginRequired"/>
                </c:if>
            </p>
        </form:form>
    </div>
    <div class='register'>
        <h2><spring:message code="loginform.registration"/></h2>
        <div class='alert'>
            <div class='fa fa-times-circle'></div>
            <spring:message code="loginform.reginfo"/>
        </div>
        <form id="register" action="/register">
            <div class = "error"></div>
            <input placeholder='<spring:message code="registerform.lname"/>' name='lname' type='text'>
            <div class = "error"></div>
            <input placeholder='<spring:message code="registerform.fname"/>' name='fname' type='text'>
            <div class = "error"></div>
            <input placeholder='<spring:message code="registerform.patronymic"/>' name='patronymic' type='text'>
            <div class = "error"></div>
            <input type="date" max="2000-01-01" min="1900-01-1" value="2012-04-10" placeholder='<spring:message code="registerform.date_of_birth"/>' name='dateOfBirth'>
            <div class = "error"></div>
            <input placeholder='<spring:message code="registerform.tin"/>' name='tin' type='text'>
            <div class = "error"></div>
            <input placeholder='<spring:message code="registerform.citizenship"/>' name='citizenship' type='text'>
            <div class = "error"></div>
            <input placeholder='<spring:message code="registerform.address"/>' name='address' type='text'>
            <div class = "error"></div>
            <input type="text" placeholder='<spring:message code="registerform.phone"/>' name='phone'>
            <div class = "error"></div>
            <input placeholder='<spring:message code="registerform.email"/>' name='email' type='email'>
            <div class = "error"></div>
            <input placeholder='<spring:message code="registerform.password"/>' name='password' type='password'>
            <div class = "error"></div>
            <input placeholder='<spring:message code="registerform.confirm_password"/>' name='confirmPassword' type='password'>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit"><spring:message code="loginform.registration"/></button>
        </form>
    </div>
    <footer>
    </footer>
</div>

<script src="/resources/js/jquery-2.1.4.min.js"></script>
<script src="/resources/js/utils.js"></script>
<script src="/resources/js/login-form.js"></script>
<script src="/resources/js/server.js"></script>
<script src="/resources/js/maskedinput.min.js"></script>

</body>
</html>
