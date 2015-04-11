<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <link rel="stylesheet" href="./css/world.css" type="text/css"/>
    <title>
        tttt
    </title>
</head>
<body>
<h1>h1</h1>
<table>
    <tr>
        <td align="right" valign="bottom">
            <button onclick="window.location='countryForm.html'">Create</button>
        </td>
    </tr>
    <tr>
        <td>
            <table class="silver" width="180">
                <tr>
                    <th> </th>
                    <th>title</th>
                </tr>
                <c:forEach items="${clients}" var="client">
                    <tr>
                        <td width="20">
                            <a href="<c:url value='countryForm.html?id=${client.id}'/>">
                                <img src="images/edit.gif" style="border-style:none;"/>
                            </a>
                        </td>
                        <td>
                            <a href="countryDetails.html?id=${client.id}">
                                    ${client.fname}
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>
</body>
</html>