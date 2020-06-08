<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${article.title}</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min.css"></script>
</head>
<body>
<section>
    <article class="section">
        <div class="container">
            <article class="message is-dark">
                <div class="message-header">
                    <p>${article.title}</p>
                </div>
                <div class="message-body">
                    ${article.content}
                </div>
                <div class="message-body is-small">
                     Autor artykułu :
                     ${article.author.username}
                </div>
            </article>
            <div class="field" style="padding: 8px">
                <label class="label"> Dodaj komentarz :: </label>
                <div class="control">
                    <form:form action="/commentaries/addArticleCommentary" modelAttribute="commentary" method="post">
                        <p>
                            treść komentarza :: <form:input cssClass="textarea" path="content"/><form:errors path="content"/>
                        </p>
                        <p>
                            Autor komentarza ::
                            <form:select path="author">
                                <form:option value="NONE" label="Wybierz..."/>
                                <form:options itemValue="id" itemLabel="username" items="${usersList}"/>
                            </form:select>
                            <form:errors path="author"/>
                        </p>
                        <p>
                            <button class="button is-primary is-small" type="submit"> dodaj komentarz </button>
                        </p>
                        <form:hidden path="article" value="${article.id}" />
                    </form:form>
                </div>
            </div>
        </div>
    </article>
</section>
</body>
</html>