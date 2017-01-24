<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel='stylesheet' href='/css/base_n_headers.css'>
    <link rel='stylesheet' href='/css/registration_n_login.css'>

    <script src='/js/jquery-3.1.1.js'></script>
    <script src='/js/header_functions.js'></script>
    <script src='/js/validator.js'></script>

</head>
<body>

<fmt:bundle basename="language" prefix="registration.">
    <fmt:message key="title" var="title"/>
    <fmt:message key="email" var="email"/>
    <fmt:message key="email_not_valid_error" var="email_not_valid_error"/>
    <fmt:message key="email_missing_error" var="email_missing_error"/>
    <fmt:message key="email_already_used_error" var="email_already_used_error"/>
    <fmt:message key="login" var="login"/>
    <fmt:message key="login_not_valid_error" var="login_not_valid_error"/>
    <fmt:message key="login_missing_error" var="login_missing_error"/>
    <fmt:message key="login_already_used_error" var="login_already_used_error"/>
    <fmt:message key="password" var="password"/>
    <fmt:message key="password_not_valid_error" var="password_not_valid_error"/>
    <fmt:message key="password_missing_error" var="password_missing_error"/>
    <fmt:message key="confirm_password" var="confirm_password"/>
    <fmt:message key="confirm_password_not_valid_error" var="confirm_password_not_valid_error"/>
    <fmt:message key="confirm_password_missing_error" var="confirm_password_missing_error"/>
    <fmt:message key="complete_signup" var="complete_signup"/>
</fmt:bundle>

<%@include file="/jsp/headers/unauth_main_header.jsp" %>

<div id="page_wrapper">
    <div class="text_field_list">
        <h2 class="title_text">${title}</h2><br>
        <form id="registration_form" action="/registration" method="post">

            <input id="registration_email_field" name="email" type="text" placeholder="${email}" value="${current_email}">
            <span id="email_missing_error" class="email_errors">${email_missing_error}</span>
            <span id="email_not_valid_error" class="email_errors">${email_not_valid_error}</span>
            <span id="email_already_used_error" class="email_errors">${email_already_used_error}</span>
            <br>

            <input id="registration_login_field" name="login" type="text" placeholder="${login}" value="${current_login}">
            <span id="login_missing_error" class="login_errors">${login_missing_error}</span>
            <span id="login_not_valid_error" class="login_errors">${login_not_valid_error}</span>
            <span id="login_already_used_error" class="login_errors">${login_already_used_error}</span>
            <br>

            <input id="registration_password_field" name="password" type="password" placeholder="${password}">
            <span id="password_missing_error" class="password_errors">${password_missing_error}</span>
            <span id="password_not_valid_error" class="password_errors">${password_not_valid_error}</span>
            <br>

            <input id="registration_confirm_password_field" name="confirm_password" type="password" placeholder="${confirm_password}">
            <span id="confirm_password_missing_error" class="confirm_password_errors">${confirm_password_missing_error}</span>
            <span id="confirm_password_not_valid_error" class="confirm_password_errors">${confirm_password_not_valid_error}</span>
            <br>

            <button>${complete_signup}</button>

        </form>
    </div>

</div>
</body>
</html>


