<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../mainheader.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Rejestracja konta</title>
</head>
<body>
<h1>Zarejestruj nowe konto</h1>
<div>
    <form:form method="post" action="/registration" modelAttribute="registrationData">
        <p>
            <form:label path="username">Nazwa użytkownika: <form:input path="username" required="required"/>
            </form:label><form:errors path="username"/>
        </p>
        <p>
            <form:label path="email">Adres e-mail: <form:input path="email" type="email" required="required"/>
            </form:label><form:errors path="email"/>
        </p>
        <p>
            <form:label path="password">Hasło: <form:password path="password" required="required"/>
            </form:label><form:errors path="password"/>
        </p>
        <p>
            <form:button type="submit">Zarejestruj</form:button><form:button type="reset">Wyczyść</form:button>
        </p>
    </form:form>
</div>
</body>
</html>