<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>...........</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min.css"></script>
</head>
<body>
<section class="section">
    <div class="container">
        <h1 class="title">
            LISTA DOSTĘPNYCH xxxxx
        </h1>
        <table class="table is-striped">
            <thead>
            <th>x</th>
            <th>y</th>
            <th>z</th>
            </thead>
            <c:forEach items="${xxxxxx}" var="xxxxxxx" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>${xxxxxxx.x}</td>
                    <td>${xxxxxxx.x}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</body>
</html>