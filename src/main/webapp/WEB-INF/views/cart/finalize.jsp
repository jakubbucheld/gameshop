<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../mainheader.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sfinalizuj zamówienie</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.css"></script>
</head>
<body>
<section class="section">
    <div class="container">
        <h1 class="title">
            Lista zamawianych produktów ::
        </h1>
        <table class="table is-striped">
            <thead>
            <th>No.</th>
            <th>Nazwa produktu</th>
            <th>Wydawca</th>
            <th>Cena jednostkowa</th>
            <th>Zamówiona ilość</th>
            <th>Akcje</th>

            </thead>
            <c:forEach items="${shoppingCart.orderRecords}" var="record" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>${record.product.name}</td>
                    <td>${record.product.publisher}</td>
                    <td>${record.unitPrice}</td>
                    <td>${record.quantity}</td>
                    <td>
                        <button class="has-text-success" type="button">
                            <i class="fas fa-plus-square "></i>
                        </button>
                        <button class="hes-text-danger" type="button">
                            <i class="fas fa-minus-square"></i>
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form:form action="/cart/finalize" method="post">
            <button class="button is-success" type="submit">
                Wyślij zamówienie
            </button>
        </form:form>
    </div>
</section>
</body>
</html>