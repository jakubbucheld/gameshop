<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj artykuł</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min-jsf.css"></script>
</head>
<body style="padding: 12px">
<form:form modelAttribute="article" method="post">
    <div class="field">
        <label class="label" style="padding: 8px"> Tytuł artykułu :: </label>
        <form:input cssClass="input is-small" path="title"/><form:errors path="title"/>
    </div>

    <div class="field" style="padding: 8px">
        <label class="label"> Treść :: </label>
        <div class="control">
        <form:input cssClass="textarea" path="content"/><form:errors path="content"/>
        </div>
    </div>

    <p style="padding: 8px">
        Autor artykułu ::
        <form:select path="author">
            <form:option value="NONE" label="Wybierz..."/>
            <form:options itemValue="id" itemLabel="username" items="${usersList}"/>
        </form:select>
        <form:errors path="category"/>
    </p>
    <p style="padding: 8px">
        Kategoria artykułu ::
        <form:select path="category">
            <form:option value="NONE" label="Wybierz..."/>
            <form:options itemValue="id" itemLabel="name" items="${categoriesList}"/>
        </form:select>
        <form:errors path="category"/>
    </p>

    <p>
        <button type="submit" class="button is-info"> Wyślij </button>
    </p>
</form:form>
</body>
</html>
