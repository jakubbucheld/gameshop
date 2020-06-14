
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.pageTitle}</title>
    <link rel="stylesheet" href="/webjars/bulma/0.8.2/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.13.0/css/all.min.css"></script>
</head>
<body>
    <nav class="navbar" role="navigation" aria-label="aria navigation">
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
                <div class="buttons">
                    <a class="button is-primary" href="/registration">
                        <strong>
                            Rejestracja
                        </strong>
                    </a>
                    <a class="button is-light" href="/login">
                        Logowanie
                    </a>
                </div>
            </div>
        </div>
    </nav>
</body>
</html>