<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="mainheader.jsp"%>
<html>
<head>
    <title>Zaloguj się</title>
</head>

<body>
<section class="hero is-light is-fullheight">
    <div class="hero-body">
        <div class="container">
            <h1 class="title">
                Zaloguj się na swoje konto
            </h1>
            <div class="level">
                <div class="level-left">
                    <div class="level-item">
                        <form action="/login" method="post">
                            <div class="field">
                                <div class="field-label has-text-left">
                                    <label class="label">Nazwa:</label>
                                </div>
                                <div class="field-body">
                                    <div class="field">
                                        <div class="control has-icons-left">
                                            <input type="text" name="username" class="input"
                                                   required="true"/>
                                            <span class="icon is-small is-left">
                                                <i class="fas fa-user"></i>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="field">
                                <div class="field-label has-text-left">
                                    <label class="label">Hasło:</label>
                                </div>
                                <div class="field-body">
                                    <div class="field">
                                        <div class="control has-icons-left">
                                            <input type="password" name="password" class="input"
                                                   required="true"/>
                                            <span class="icon is-small is-left">
                                                <i class="fas fa-lock"></i>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="field is-horizontal">
                                <div class="field-label"></div>
                                <div class="field-body">
                                    <div class="control">
                                        <button class="button is-primary">Zaloguj</button>
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="referer" value="${referer}"/>
                            <sec:csrfInput/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>