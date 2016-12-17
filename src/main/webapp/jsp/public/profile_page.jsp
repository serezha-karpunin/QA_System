<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <script src='/js/jquery-3.1.1.js'></script>
    <script src='/js/header_functions.js'></script>
    <script src='/js/profile_page_functions.js'></script>
    <script src='/js/answer_element_functions.js'></script>

    <link rel='stylesheet' href='/css/base_n_headers.css'>
    <link rel='stylesheet' href='/css/question.css'>
    <link rel='stylesheet' href='/css/answer.css'>
    <link rel='stylesheet' href='/css/profile.css'>
</head>
<body>
<fmt:setLocale value="en"/>
<fmt:bundle basename="language" prefix="profile.">
    <fmt:message key="registration_date" var="date"/>
    <fmt:message key="questions_label" var="questions_label"/>
    <fmt:message key="answers_label" var="answers_label"/>

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
                <b>${userBean.questionCount}</b><br><p>${questions_label}</p>
            </div>
            <div class="profile_page_user_stat">
                <b>${userBean.answerCount}</b><br><p>${answers_label}</p>
            </div>
        </div>


        <div id="profile_page_tabs">
            <div class="tabs">
                <input id="tab_questions" type="radio" name="tabs">
                <label for="tab_questions">${questions_label}</label>

                <input id="tab_answers" type="radio" name="tabs">
                <label for="tab_answers">${answers_label}</label>
            </div>
        </div>
        <section id="questions_content">
            <c:forEach var="question" items="${userQuestions}">
                <%@include file="/jsp/parts/question.jsp" %>
            </c:forEach>
        </section>
        <section id="answers_content">
            <br>
            <c:forEach var="answer" items="${userAnswers}">
                <a href="/question_page?id=${answer.idQuestion}"><h3>${answer.title}</h3></a>
                <%@include file="/jsp/parts/answer.jsp" %>
                <br>
            </c:forEach>
        </section>

    </div>
</div>
</body>
</html>
