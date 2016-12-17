<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel='stylesheet' href='/css/base_n_headers.css'>
    <link rel='stylesheet' href='/css/profile.css'>
    <link rel='stylesheet' href='/css/settings.css'>

    <script src='/js/jquery-3.1.1.js'></script>
    <script src='/js/header_functions.js'></script>
</head>

<body>
<fmt:setLocale value="en"/>
<%@include file="/jsp/headers/auth_main_header.jsp" %>

<fmt:bundle basename="language" prefix="settings.">
    <fmt:message key="title" var="title"/>
    <fmt:message key="language" var="language"/>
    <fmt:message key="ru" var="ru"/>
    <fmt:message key="en" var="en"/>
    <fmt:message key="save" var="save"/>
    <fmt:message key="saved" var="saved"/>
</fmt:bundle>

<div id="page_wrapper">
    <div id="user_page_content_wrapper">
        <%@include file="/jsp/parts/profile_header.jsp" %>
        <div id="settings_title_line">
            ${title}
        </div>
        <form id="settings_form" action="/save_settings" method="post">
            <span>${language}</span>
            <c:choose>
                <c:when test="${userBean.lang eq 'ru'}">
                    <select name="language">
                        <option value="ru" selected>${ru}</option>
                        <option value="en">${en}</option>
                    </select>
                </c:when>
                <c:otherwise>
                    <select name="language">
                        <option value="ru">${ru}</option>
                        <option value="en" selected> ${en}</option>
                    </select>
                </c:otherwise>
            </c:choose>
            <br>
            <button id="settings_form_save_button">${save}</button>
            <c:if test="${not empty saved}">
                <span>${saved}</span>
            </c:if>
        </form>
    </div>
</div>
</body>
</html>