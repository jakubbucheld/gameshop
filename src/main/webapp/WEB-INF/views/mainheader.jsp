<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.pageTitle}</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/js/all.min.js"></script>
</head>
<body>
    <nav class="navbar has-background-light" role="navigation" aria-label="main navigation">
        <div class="navbar-brand">
           <a href="localhost:8080/"></a>
        </div>
        <div class="navbar-menu">
            <div class="navbar-start">
                <a class="navbar-item" href="/">
                    <i class="fa fa-home is-pulled-left"></i>
                    &nbsp Strona główna
                </a>
                <div class="navbar-item has-dropdown is-hoverable" href="/articles/all">
                   <a class="navbar-link">
                       <i class="far fa-newspaper"></i>
                       &nbsp Artykuły
                   </a>
                    <div class="navbar-dropdown">
                         <a class="navbar-item" href="/articles/add">
                             <i class="far fa-file"></i>
                             &nbsp
                             Dodaj artykuł
                         </a>
                        <a class="navbar-item" href="/articles/all">
                            <i class="far fa-newspaper"></i>
                            &nbsp
                            Zobacz wszystkie
                        </a>
                    </div>

                </div>
                <div class="navbar-item has-dropdown is-hoverable" href="/products/all">
                    <a class="navbar-link">
                        <i class="fas fa-boxes"></i>
                        &nbsp Produkty
                    </a>
                    <div class="navbar-dropdown">
                        <a class="navbar-item" href="/products/add">
                            <i class="fas fa-plus-circle"></i>
                            &nbsp
                            Dodaj produkt
                        </a>
                        <a class="navbar-item" href="/products/all">
                            <i class="fas fa-warehouse"></i>
                            &nbsp
                            Zobacz wszystkie
                        </a>
                    </div>
                </div>
                <div class="navbar-item has-dropdown is-hoverable" href="/articles/all">
                    <a class="navbar-link">
                        <i class="far fa-newspaper"></i>
                        &nbsp Uzupełnianie DB
                    </a>
                    <div class="navbar-dropdown">
                        <a class="navbar-item" href="/categories/add">
                            Dodaj kategorię
                        </a>
                        <a class="navbar-item" href="/games/all">
                            Dodaj grę
                        </a>
                        <a class="navbar-item" href="/publishers/add">
                            Dodaj wydawcę
                        </a>
                    </div>
                </div>
                <div class="navbar-item">
                    <a class="navbar-item" href="users/all">
                        <i class="fas fa-users"></i>
                        &nbsp Zarządzaj użytkownikami
                    </a>
                </div>
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
                        &nbsp <i class="fas fa-user-check" style="color: darkgreen;"></i> &nbsp
                            Zalogowano jako : &nbsp<strong><sec:authentication property="name"/>&nbsp&nbsp&nbsp&nbsp</strong>
                        <div class="buttons">
                            <form action="/logout" method="post">
                                <sec:csrfInput/>
                                <button class="button is-danger" type="submit">
                                    Wyloguj
                                </button>
                            </form>
                        </div>
                    </sec:authorize>
                </div>
            </div>
    </nav>
</body>
</html>
