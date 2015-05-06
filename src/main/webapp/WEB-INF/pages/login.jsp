<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <sec:csrfMetaTags/>
</head>
<body>
<form action="login" method="post">
    <p>
        <label for="password">Username:</label>
        <input type="text" id="username" name="username" />
    </p>
    <p>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" />
    </p>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <p>
        <input type="submit" value="Login"/>
    </p>
</form>
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

</body>
</html>
