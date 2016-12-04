<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel='stylesheet' href='/css/main_css.css'>
    <script src='/js/jquery-3.1.1.js'></script>
    <script src='/js/validator.js'></script>

</head>
<body>
<%--<fmt:setLocale value="${cookie.get('language').value}"/>--%>
<fmt:setLocale value="en"/>

<fmt:bundle basename="language" prefix="registration.">
    <fmt:message key="email" var="email"/>
    <fmt:message key="email_not_valid_error" var="email_not_valid_error"/>
    <fmt:message key="email_missing_error" var="email_missing_error"/>
    <fmt:message key="email_already_used_error" var="email_already_used_error"/>
    <fmt:message key="login" var="login"/>
    <fmt:message key="login_not_valid_error" var="login_not_valid_error"/>
    <fmt:message key="login_missing_error" var="login_missing_error"/>
    <fmt:message key="login_already_used_error" var="login_already_used_error"/>
</fmt:bundle>
<div id="page_wrapper">
    <%--<%@include file="/jsp/headers/unauth_main_header.jsp" %>--%>

    <div class="text_field_list">
        <form id="registration_form" action="/registration" method="post">

            <input id="email_field" name="email" type="text" placeholder="${email}">
            <span id="email_missing_error" class="email_errors">${email_missing_error}</span>
            <span id="email_not_valid_error" class="email_errors">${email_not_valid_error}</span>
            <span id="email_already_used_error" class="email_errors">${email_already_used_error}</span>
            <br>

            <input id="login_field" name="login" type="text" placeholder="${login}">
            <span id="login_missing_error" class="login_errors">${login_missing_error}</span>
            <span id="login_not_valid_error" class="login_errors">${login_not_valid_error}</span>
            <span id="login_already_used_error" class="login_errors">${login_already_used_error}</span>
            <br>

            <input id="password_field" name="password" type="text" placeholder="Create a password">
            <span id="error_missing_password">введите пароль</span>
            <br>

            <input id="confirm_password_field" name="confirm_password" type="text" placeholder="Confirm password">
            <span id="error_missing_confirm_password">повторите пароль</span>
            <span id="error_not_valid_confirm_password">пароли не сходятся</span>

            <button>Complete Sign-Up</button>
            ${param.login}

        </form>
    </div>
</div>
</body>
</html>


