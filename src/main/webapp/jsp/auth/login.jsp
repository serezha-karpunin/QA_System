<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel='stylesheet' href='/css/main_style.css'>
    <script src='/js/jquery-3.1.1.js'></script>
    <script src='/js/header_functions.js'></script>
    <script src='/js/validator.js'></script>
    <script src='/js/page_functions.js'></script>
</head>
<body>
<fmt:setLocale value="en"/>

<%--<fmt:bundle basename="language" prefix="registration.">--%>
<%--<fmt:message key="login" var="login"/>--%>

<%--</fmt:bundle>--%>
<fmt:bundle basename="language" prefix="authorization.">
    <fmt:message key="title" var="title"/>
</fmt:bundle>

<%@include file="/jsp/headers/unauth_main_header.jsp" %>

<div id="page_wrapper">
    ${errorLogin}
    ${sessionScope.userLogin}
    ${param.errorLogin.toString()}
    <div class="text_field_list">
        <h2>${title}</h2>
        <form id="login_page_login_form" action="/login" method="post">
            <input id="login_page_email_field" name="login" type="text" placeholder="${auth_email_login}">
            <br>
            <input id="login_page_password_field" name="password" type="text" placeholder="${auth_password}">
            <br>
            <button>${signin}</button>
        </form>
        <form action="/jsp/auth/registration.jsp" method="get">
            <button id="call_registration_page_button">${auth_registration}</button>
        </form>
    </div>
</div>

</body>
</html>
