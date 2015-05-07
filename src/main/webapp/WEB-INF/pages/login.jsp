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
        <form action="login" method="post">
            <input placeholder='<spring:message code="loginform.id"/>' type='text' id="username" name="username">
            <input placeholder='<spring:message code="loginform.pass"/>' type='password' id="password" name="password">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button><spring:message code="loginform.login"/></button>
            <p style="color:red">
                <c:if test="${param.error == 'invalidLoginPassword'}">
                    Invalid login or password. Please check and try again.
                </c:if>
            </p>

            <p style="color:blue">
                <c:if test="${param.error == 'loginRequired'}">
                    You are currently logged off. Please log in.
                </c:if>
            </p>
        </form>
    </div>
    <div class='register'>
        <h2><spring:message code="loginform.registration"/></h2>
        <div class='alert'>
            <div class='fa fa-times-circle'></div>
            <spring:message code="loginform.reginfo"/>
        </div>
        <form>
            <input placeholder='Username' type='text'>
            <input placeholder='Password' type='password'>
            <input placeholder='Confirm Password' type='password'>
            <input placeholder='Email Address' type='email'>
            <input placeholder='Birth Date (mm/dd/yy)' type='text'>
            <button><spring:message code="loginform.registration"/></button>
        </form>
    </div>
    <footer>
    </footer>
</div>

<script src="/resources/js/jquery-2.1.4.min.js"></script>
<script src="/resources/js/login-form.js"></script>
</body>
</html>
