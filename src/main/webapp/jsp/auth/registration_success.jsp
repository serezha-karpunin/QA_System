<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel='stylesheet' href='/css/base_n_headers.css'>
    <link rel='stylesheet' href='/css/registration_success_page.css'>
    <script src='/js/jquery-3.1.1.js'></script>
    <script src='/js/header_functions.js'></script>

</head>
<body>

<c:choose>
<c:when test="${not empty userLogin}">
    <%@include file="/jsp/headers/auth_main_header.jsp" %>
</c:when>
<c:otherwise>
    <%@include file="/jsp/headers/unauth_main_header.jsp" %>
</c:otherwise>
</c:choose>

<fmt:bundle basename="language" prefix="registration_success_page.">
    <fmt:message key="title" var="title"/>
    <fmt:message key="message" var="message"/>
    <fmt:message key="login_link" var="login_link"/>
    <fmt:message key="back" var="back"/>

</fmt:bundle>
<div id="page_wrapper">
    <div id="registration_success_page_content_wrapper">
        <h1 class="registration_success_page_title">${title}</h1>
        <p class="registration_success_page_message">${message}</p><br>
        <div class="registration_success_page_back_link_wrapper">
            <a class="registration_success_page_auth_link" href="/jsp/auth/login.jsp">${login_link}</a>
            <a class="registration_success_page_back_link" href="/">${back}</a>
        </div>
    </div>
</div>