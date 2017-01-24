<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel='stylesheet' href='/css/base_n_headers.css'>
    <link rel='stylesheet' href='/css/main_page.css'>
    <link rel='stylesheet' href='/css/question.css'>
    <script src='/js/jquery-3.1.1.js'></script>
    <script src='/js/header_functions.js'></script>
    <script src='/js/main_page_functions.js'></script>
    <meta charset="utf-8" />

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

<fmt:bundle basename="language" prefix="main_page.">
    <fmt:message key="title" var="title"/>
    <fmt:message key="last_questions_tab" var="last"/>
    <fmt:message key="interesting_questions_tab" var="interesting"/>
</fmt:bundle>
<div id="page_wrapper">

    <div id="main_page_title_and_tabs">
        <h2 class="title_text">${title}</h2>
        <div class="tabs">
            <input id="tab_last" type="radio" name="tabs">
            <label for="tab_last">${last}</label>

            <input id="tab_interest" type="radio" name="tabs">
            <label for="tab_interest">${interesting}</label>
        </div>
    </div>
    <section id="last_content">
        <c:forEach var="question" items="${lastQuestions}">
            <%@include file="/jsp/parts/question.jsp" %>
        </c:forEach>
    </section>
    <section id="interesting_content">
        <c:forEach var="question" items="${interestingQuestions}">
            <%@include file="/jsp/parts/question.jsp" %>
        </c:forEach>
    </section>
</div>
</body>
</html>

