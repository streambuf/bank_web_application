<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="js/jquery-2.1.4.min.js"></script>

    <title>
        <spring:message code="application.name"/>
        <sec:csrfMetaTags/>
    </title>
</head>
<body>
<h1></h1>

<form action="/logout" method="post">
    <input type="submit" value="Log out" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>


<p>Общедоступная</p>
<sec:authorize access="hasRole('ROLE_CLIENT',)">
    <p>Пользователь</p>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_EMPLOYEE')">
    <p>Сотрудник</p>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <p>Админ</p>
</sec:authorize>

</body>
</html>