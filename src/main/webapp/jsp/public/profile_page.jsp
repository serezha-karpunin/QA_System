<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel='stylesheet' href='/css/base_n_headers.css'>
    <script src='/js/jquery-3.1.1.js'></script>
    <script src='/js/header_functions.js'></script>

    <link rel='stylesheet' href='/css/base_n_headers.css'>
    <link rel='stylesheet' href='/css/question.css'>
    <link rel='stylesheet' href='/css/answer.css'>
    <link rel='stylesheet' href='/css/profile.css'>
    <%--<script src='/js/profile_page_functions.js'></script>--%>
</head>
<body>
<fmt:setLocale value="en"/>
<fmt:bundle basename="language" prefix="profile.">
    <fmt:message key="registration_date" var="date"/>
    <fmt:message key="number_of_questions" var="number_of_questions"/>
    <fmt:message key="number_of_answers" var="number_of_answers"/>

</fmt:bundle>
<%@include file="/jsp/headers/auth_main_header.jsp" %>

<div id="page_wrapper">
    <div id="profile_page_content_wrapper">
        <div id="profile_page_user_panel">
            <img id="avatar" src="/avatar.png">
            <div id="profile_page_user_info">
                <h2 class="title_text">${userBean.login}</h2>
                <p>${date}: ${userBean.registrationDate}</p>
            </div>
            <div class="profile_page_user_stat">
                <b>${userBean.questionCount}</b><br><p>${number_of_questions}</p>
            </div>
            <div class="profile_page_user_stat">
                <b>${userBean.answerCount}</b><br><p>${number_of_answers}</p>
            </div>
        </div>

        <c:forEach var="question" items="${userQuestions}">
            <%@include file="/jsp/parts/question.jsp" %>
        </c:forEach>
    </div>
</div>
</body>
</html>
