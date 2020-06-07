<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title> Dodaj grę: </title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min-jsf.css"></script>
</head>
<body>
<form:form modelAttribute="product" method="post">
    <p>
        Nazwa produktu :  <form:input path="name"/><form:errors path="name"/>
    </p>
    <p>
        Opis : <form:input path="description"/><form:errors path="description"/>
    </p>

    <p>
        Cena : <form:input path="priceInPln"/><form:errors path="priceInPln"/>
    </p>

    <p>
        Powiązana gra ::
        <form:select path="game" >
            <form:option value="UNKNOWN" label = "Select"/>
            <form:options itemValue="id" itemLabel="name" items="${gamesList}"/>
        </form:select>
        <form:errors path="game"/>
    </p>

    <p>
        Wydawca ::
        <form:select path="publisher" >
            <form:option value="UNKNOWN" label = "Select"/>
            <form:options itemValue="id" itemLabel="name" items="${publishersList}"/>
        </form:select>
        <form:errors path="publisher"/>
    </p>

    <p>
        Kategoria produktu :: 
        <form:select path="category">
            <form:option value="NONE" label="Wybierz..."/>
            <form:options itemValue="id" itemLabel="name" items="${categoriesList}"/>
        </form:select>
        <form:errors path="category"/>
    </p>
    
    <p>
        <form:button> SUBMIT </form:button>
    </p>
</form:form>
</body>
</html>
