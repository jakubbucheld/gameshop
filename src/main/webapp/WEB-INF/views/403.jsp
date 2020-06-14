<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="mainheader.jsp"%>
<html>
<head>
    <title>403</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min.css"></script>
</head>
<body>
<h2>Nie posiadasz uprawnień do wyświetlenia tej strony</h2>

Kliknij <a href="<c:url value="/" /> "> tutaj </a>
aby wrócić do strony głównej
</body>
</html>
