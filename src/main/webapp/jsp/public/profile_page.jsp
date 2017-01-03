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

<c:choose>
    <c:when test="${not empty userLogin}">
        <%@include file="/jsp/headers/auth_main_header.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="/jsp/headers/unauth_main_header.jsp" %>
    </c:otherwise>
</c:choose>

<div id="page_wrapper">
    <div id="user_page_content_wrapper">
        <%@include file="/jsp/parts/profile_header.jsp" %>

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
            <c:forEach var="answer" items="${userAnswers}">
                <br>
                <a href="/question_page?id=${answer.idQuestion}"><h3>${answer.title}</h3></a>
                <%@include file="/jsp/parts/answer.jsp" %>
            </c:forEach>
        </section>

    </div>
</div>
</body>
</html>
