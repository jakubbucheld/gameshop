<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../mainheader.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Produkty</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min.css"></script>
</head>
<body>
<section class="section columns is-fullheight is-fullwidth">
    <div class="container column is-10">
        <h1 class="title">
           Dostępne produkty
        </h1>
        <div class="container">
            <div class="tile is-ancestor" style="flex-wrap: wrap">
                <c:forEach items="${products}" var="product" varStatus="stat">
                    <div class="tile is-parent is-4">
                        <article class="tile is-child is-dark message" style="margin: 20px; padding: 20px">
                            <a href="/products/view/${product.id}">
                                <p class="message-header" style="flex-wrap: wrap">
                                    ${product.name}
                                </p>
                            </a>
                            <p class="message-body" style="flex-wrap: wrap">
                                Opis :: ${product.description} <br>
                                Cena :: ${product.priceInPln}
                            </p>
                            <div class="field">
                                <form:form action="/cart/addRecord" modelAttribute="orderRecord" method="post">
                                    <p>
                                        <form:input cssClass="input" path="quantity"/><form:errors path="quantity"/>
                                    </p>
                                    <form:hidden path="product" value="${product.id}"/>
                                    <form:hidden path="unitPrice" value="${product.priceInPln}"/>
                                    <p>
                                        <button class="button is-success" type="submit">
                                            Dodaj do koszyka
                                        </button>
                                    </p>
                                </form:form>
                            </div>
                        </article>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="container column is-2">
        <div class="box is-fullheight">
            KOSZYK ::
            <div class="field">
                <table class="table">
                    <thead>
                        <th>No.</th>
                        <th>Nazwa</th>
                        <th>Ilość</th>
                    </thead>
                    <c:forEach items="${sessionScope.shoppingCart.orderRecords}" var="record" varStatus="count">
                        <tr>
                            <td>${count.count}</td>
                            <td>${record.product.name}</td>
                            <td>${record.quantity}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div>
                <a href="/cart/finalize" class="button is-warning">PODSUMOWANIE</a>
            </div>
        </div>

    </div>
</section>
</body>
</html>
