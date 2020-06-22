<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../mainheader.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${product.name}</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min.css"></script>
</head>
<body>
<section>
    <article class="section">
        <div class="container">
            <article class="message is-dark">
                <div class="message-header">
                    <p>${product.name}</p>
                    <p class="is-small">${product.category.name}</p>
                </div>
                <div class="message-body is-small">
                    Opis produktu ::
                    ${product.description}
                    Wydawca ::
                    ${product.publisher.name}
                    <p class="box is-warning">
                        CENA :: ${product.priceInPln}
                    </p>
                </div>
            </article>
            <div class="field" style="padding: 8px">
                <label class="label"> Dodaj komentarz :: </label>
                <div class="control">
                    <form:form action="/commentaries/addProductCommentary" modelAttribute="commentary" method="post">
                        <p>
                            treść komentarza :: <form:input cssClass="textarea" path="content"/><form:errors path="content"/>
                        </p>
                        <p>
                            ocena :: <form:input path="score" cssClass="number"/><form:errors path="score"/>
                        </p>
                        <p>
                            <button class="button is-primary is-small" type="submit"> dodaj komentarz </button>
                        </p>
                        <form:hidden path="product" value="${product.id}" />
                    </form:form>
                </div>
                <div>
                    <c:forEach items="${currentCommentaryList}" var="commentary" varStatus="count">
                        <article class="field has-addons is-fullwidth is-parent ${commentary.author.roles.contains('ROLE_AUTHOR') ? 'message is-success' : 'message is-info'}">
                            <div class="is-10 control">
                                <div class="message-header">
                                    <p><strong>${commentary.author.username}</strong> | ${commentary.timeCreated} </p>
                                </div>
                                <div class="message-body">
                                    ${commentary.content}
                                    <br>
                                        <c:if test="${not empty commentary.score}">
                                    OCENA ::
                                        <strong> ${commentary.score} </strong>
                                        </c:if>
                                </div>
                            </div>
                        </article>
                    </c:forEach>
                </div>
            </div>
        </div>
    </article>
</section>
</body>
</html>