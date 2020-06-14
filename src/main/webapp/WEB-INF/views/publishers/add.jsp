<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../mainheader.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dodaj wydawcę:</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min.css"></script>
</head>

<body>
<form:form modelAttribute="publisher" method="post">
    <p>
        Nazwa :: <form:input path="name"/><form:errors path="name"/>
    </p>
    <p>
        <form:button> SUBMIT BUTTON </form:button>
    </p>
</form:form>
</body>
</html>