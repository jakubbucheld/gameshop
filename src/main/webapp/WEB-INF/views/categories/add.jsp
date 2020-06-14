<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../mainheader.jsp"%>
<html>
<head>
    <title>Dodawanie kategorii</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min-jsf.css"></script>
</head>
<body>
<form:form modelAttribute="category" method="post">
    <p>
        Nazwa kategorii :: <form:input path="name"/><form:errors path="name"/>
    </p>
    <p>
        Grupa kategorii <form:select path="categoryGroup">
        <form:option value="UNKNOWN" label = "Select"/>
        <form:options items="${categoriesEnum}"/>
        </form:select>
        <form:errors path="categoryGroup"/>
    </p>
    <p>
        <form:button> SUBMIT BUTTON </form:button>
    </p>
</form:form>
</body>
</html>
