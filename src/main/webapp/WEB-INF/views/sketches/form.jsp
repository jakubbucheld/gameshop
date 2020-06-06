<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>...................</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min-jsf.css"></script>
</head>
<body>
    <form:form modelAttribute="......." method="post">
        <p>
            someText <form:input path="PATH"/><form:errors path="PATH"/>
        </p>

        <p>
            someText <form:input path="PATH"/><form:errors path="PATH"/>
        </p>

        <p>
            someText <form:input path="PATH"/><form:errors path="PATH"/>
        </p>

        <p>
            someText <form:input path="PATH"/><form:errors path="PATH"/>
        </p>

        <p>
            <form:button> SUBMIT BUTTON </form:button>
        </p>
    </form:form>
</body>
</html>
