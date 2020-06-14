<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Wyszukiwanie artykułów</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min.css"></script>
</head>
<body>
<section class="section">
    <div class="container">
        <h1 class="title">
            LISTA PASUJĄCYCH ARTYKUŁÓW
        </h1>
        <table class="table is-striped">
            <thead>
            <th>No.</th>
            <th>Tytuł</th>
            <%--            <th>Treść</th>--%>
            <th>Autor</th>
            <th>Dodano</th>
            </thead>
            <c:forEach items="${searchedArticlesList}" var="article" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>
                        <a href="/articles/read/${article.id}">
                                ${article.title}
                        </a>
                    </td>
                        <%--                    <td>${article.content}</td>--%>
                    <td>${article.author.username}</td>
                    <td>${article.timeCreated}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</body>
</html>
