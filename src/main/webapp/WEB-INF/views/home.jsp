<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hello Bulma!</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.2/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<section class="section">
    <div class="container">
        <h1 class="title">
            <sec:authorize access="hasRole('ADMIN')"></sec:authorize>
            <sec:authorize access="isAuthenticated()">
                Witaj userze <sec:authentication property="name"/>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                Witaj, niezalogowany
            </sec:authorize>
        </h1>
        <p class="subtitle">
            My first website with <strong>Bulma</strong>!
        </p>
    </div>
</section>
</body>
</html>