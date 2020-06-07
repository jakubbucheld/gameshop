<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Kategorie</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min.css"></script>
</head>
<body>
<section class="section">
    <div class="container">
        <h1 class="title">
            LISTA DOSTĘPNYCH KATEGORII
        </h1>
        <a href="/categories/add">
            <button class="button is-link" type="button"> Dodaj nową kategorię </button>
        </a>
        <table class="table is-striped" >
            <thead>
            <th>No.</th>
            <th>Nazwa kategorii</th>
            <th>Grupa kategorii</th>
            </thead>
            <c:forEach items="${categoriesList}" var="category" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>${category.name}</td>
                    <td>${category.categoryGroup}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</body>
</html>