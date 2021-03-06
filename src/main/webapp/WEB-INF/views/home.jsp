<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="mainheader.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hello Bulma!</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min-jsf.css"></script>
</head>
<body>
<section class="title is-centered" style="padding: 20px">
    <h2> OTO NAJŚWIEŻSZE ARTYKUŁY </h2>
</section>
<section>
        <div class="container">
            <div class="tile is-ancestor" style="flex-wrap: wrap">
                    <c:forEach items="${lastTenArticles}" varStatus="stat" var="article" >
                        <div class="tile is-parent is-4">
                            <article class="tile is-child is-success box" style="margin: 20px">
                                <a style="color: azure" href="articles/read/${article.id}">
                                    <p class="message-header">
                                        ${article.title}
                                    </p>
                                </a>
                                <p class="message-body"> Autor : ${article.author.username}</p>
                            </article>
                        </div>
                    </c:forEach>

            </div>
        </div>
</section>
</body>
</html>