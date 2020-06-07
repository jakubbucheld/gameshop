<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lista użytkowników</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min.css"></script>
</head>

<section class="section">
    <div class="container">
        <h1 class="title">
            Lista dostępnych użytkowników
        </h1>
        <table class="table is-striped">
            <thead>
            <th>No.</th>
            <th>Nazwa użytkownika</th>
            <th>Email użytkownika</th>
            <th>Posiadane role</th>
            <th>Akcje</th>
            </thead>
            <c:forEach items="${usersList}" var="user" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>
                        <c:forEach items="${user.roles}" varStatus="smallstat" var="role">
                            <form method="post" action="/users/${user.id}/deleteroles">
                                <sec:csrfInput/>
                                <button type="submit" name="roleName" value="${role}" class="button is-small is-outlined is-danger is-link is-light">Odbierz rolę ${role}</button>
                            </form>
<%--                            <p>${smallstat.count}. - ${role}--%>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${rolesList}" var="role" varStatus="smallstat">
                            <form method="post" action="/users/${user.id}/addroles">
                                <c:if test="${!user.roles.contains(role)}">
                                    <sec:csrfInput/>
                                    <button type="submit" name="roleName" value="${role}" class="button is-small is-outlined is-success is-link is-light">Nadaj rolę ${role}</button>
                                </c:if>
                            </form>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</body>
</html>