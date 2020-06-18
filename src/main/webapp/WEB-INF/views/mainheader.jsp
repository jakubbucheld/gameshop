<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.pageTitle}</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.css"></script>
</head>
<body>
    <nav class="navbar has-background-light" role="navigation" aria-label="aria navigation">
        <div class="navbar-brand">
           <a href="localhost:8080/"></a>
        </div>
        <div class="navbar-menu">
            <div class="navbar-start">
                <a class="navbar-item" href="/">
                   <span class="icon is-medium"><i class="fas fa-home" aria-hidden="true"></i></span>
                   <span>Strona główna</span>
                </a>
                <a class="navbar-item" href="/articles/all">
                   <span class="icon is-medium"><i class="fas fa-newspaper" aria-hidden="true"></i></span>
                   <span>Artykuły</span>
                </a>
                <a class="navbar-item" href="/products/all">
                   <span class="icon is-medium"><i class="fas fa-store" aria-hidden="true"></i></span>
                   <span>Produkty</span>
                </a>
                <a class="navbar-item" href="/about">
                   <span class="icon is-medium"><i class="fas fa-address-card"></i></span>
                   <span>O nas</span>
                </a>
            </div>
        </div>
            <div class="navbar-end">
                <div class="navbar-item">
                    <sec:authorize access="!isAuthenticated()">
                        <div class="buttons">
                            <a class="button is-info" href="/registration">
                                <strong>
                                    Rejestracja
                                </strong>
                            </a>
                            <a class="button is-primary" href="/login">
                                Logowanie
                            </a>
                        </div>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                            Zalogowano jako : &nbsp<strong><sec:authentication property="name"/>&nbsp&nbsp&nbsp&nbsp</strong>
                        <div class="buttons">
                            <a class="button is-danger" href="/logout">
                                Wyloguj
                            </a>
                        </div>
                    </sec:authorize>
                </div>
            </div>
    </nav>
</body>
</html>
