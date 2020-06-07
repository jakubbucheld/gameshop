<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        </div>
    </article>
</section>
</body>
</html>