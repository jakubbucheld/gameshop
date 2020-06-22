<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../mainheader.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Wszystkie artykuły</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min.css"></script>
</head>
<body>

<section class="section columns is-fullheight">
    <div class="container column is-1 is-narrow message">
        <p class="menu-label is-hidden-touch"> NAWIGACJA</p>
        <ul class="menu-list">
            <li style="padding: 3px">
                <a href="/articles/add" class="button is-primary is-fullwidth" >Dodaj artykuł</a>
            </li>
            <li style="padding: 3px">
                <a class="button is-danger is-fullwidth"> opcja 2 </a>
            </li>
            <li style="padding: 3px">
                <a class="button is-warning is-fullwidth"> opcja 3 </a>
            </li>
            <li style="padding: 3px">
                <a class="button is-info is-fullwidth"> opcja 4 </a>
            </li>
        </ul>
    </div>
    <div class="container column is-11">
        <h1 class="title">
            LISTA DOSTĘPNYCH ARTYKUŁÓW
        </h1>
        <div class="container">
            <label class="label">Szukaj...</label>
            <form action="/articles/all">
                <c:set var="searchPhrase" scope="request" value='<%= request.getParameter("search") %>'/>
                <c:choose>
                <c:when test="${searchPhrase} == null">
                    <c:set var="searchedFor" scope="request" value=""/>
                </c:when>
                <c:otherwise>
                    <c:set var="searchedFor" scope="request" value='<%= request.getParameter("search") %>'/>
                </c:otherwise>
                </c:choose>
                    <div class="field has-addons is-fullwidth">
                        <div class="control is-expanded">
                            <input class="input" type="text" name="search" placeholder="<c:out value='${searchedFor}'/>"/>
                        </div>
                        <div class="control">
                            <input class="button is-info" type="submit">
                        </div>
                    </div>
            <div class="tile is-ancestor" style="flex-wrap: wrap">
                <c:forEach items="${articlesList}" varStatus="stat" var="article" >
                    <div class="tile is-parent is-4">
                        <article class="tile is-child is-success box" style="margin: 20px">
                            <a style="color: azure" href="/articles/read/${article.id}">
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

<%--     LISTA ARTYKUŁÓW   --%>

<%--        <div class="section">--%>
<%--            <table class="table is-striped">--%>
<%--                <thead>--%>
<%--                <th>No.</th>--%>
<%--                <th>Tytuł</th>--%>
<%--                <th>Autor</th>--%>
<%--                </thead>--%>
<%--                <c:forEach items="${articlesList}" var="article" varStatus="stat">--%>
<%--                    <tr>--%>
<%--                        <td>${stat.count}</td>--%>
<%--                        <td>--%>
<%--                            <a href="/articles/read/${article.id}">--%>
<%--                                    ${article.title}--%>
<%--                            </a>--%>
<%--                        </td>--%>
<%--                        <td>${article.author.username}</td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--            </table>--%>
<%--        </div>--%>

    </div>
</section>
</body>
</html>