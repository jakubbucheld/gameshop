<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Produkty</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min.css"></script>
</head>

<section class="section">
    <div class="container">
        <h1 class="title">
           LISTA DOSTĘPNYCH PRODUKTÓW
        </h1>
        <table class="table is-striped">
            <thead>
                <th>No.</th>
                <th>Name</th>
                <th>Game</th>
                <th>Price</th>
            </thead>
            <c:forEach items="${products}" var="product" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>${product.name}</td>
                    <td>a</td>
                    <td>${product.priceInPln}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</body>
</html>
