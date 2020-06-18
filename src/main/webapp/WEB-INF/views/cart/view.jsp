<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../mainheader.jsp"%>
<html>
<head>
    <title>Koszyk</title>
</head>
<body>
    <c:out value="${sessionScope.shoppingCart}">

    </c:out>
</body>
</html>
