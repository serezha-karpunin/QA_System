<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel='stylesheet' href='/css/base_n_headers.css'>
    <link rel='stylesheet' href='/css/question.css'>
    <link rel='stylesheet' href='/css/answer.css'>
    <script src='/js/jquery-3.1.1.js'></script>
    <script src='/js/header_functions.js'></script>
    <script src='/js/page_functions.js'></script>

</head>
<body>
<fmt:setLocale value="en"/>
<fmt:bundle basename="language" prefix="question_page.">
    <fmt:message key="answers" var="answers"/>
    <fmt:message key="your_answer" var="your_answer"/>
    <fmt:message key="post_answer" var="post"/>
    <fmt:message key="call_auth" var="call_auth"/>

</fmt:bundle>

<c:choose>
    <c:when test="${not empty userLogin}">
        <%@include file="/jsp/headers/auth_main_header.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="/jsp/headers/unauth_main_header.jsp" %>
    </c:otherwise>
</c:choose>

<div id="page_wrapper">
    <div id="question_page_content_wrapper">
        <div id="question_page_author_line">
            <button id="question_page_author_button"><img src="/avatar.png"/>${questionBean.login}</button>
            <p>${questionBean.date}</p>
        </div>
        <div id="question_page_theme_line">
            <h2>${questionBean.title}</h2>
        </div>
        <div id="question_text_area">
            <p>${questionBean.text}</p>
        </div>
        <div id="question_page_tags_line">
            <div class="tags">
                <c:forEach var="tag" items="${questionBean.tags}">
                    <button>${tag}</button>
                </c:forEach>
            </div>
        </div>

        <h3>${answers}</h3>

        <c:forEach var="answer" items="${questionBean.answers}">
            <%@include file="/jsp/parts/answer.jsp" %>
        </c:forEach>

        <%--<%@include file="/jsp/parts/answer.jsp" %>--%>
        <%--<%@include file="/jsp/parts/answer.jsp" %>--%>

        <br>

        <c:choose>
            <c:when test="${not empty userLogin}">
                <h3>${your_answer}</h3>
                <textarea id="answer_text_field" rows="7"></textarea>
                <button id="post_answer_button">${post}</button>
            </c:when>
            <c:otherwise>
                <form action="/jsp/auth/login.jsp" method="get">
                    <button class="question_page_call_auth_button">${call_auth}</button>
                </form>
            </c:otherwise>
        </c:choose>
        <%--<h3>${your_answer}</h3>--%>
        <%--<textarea id="answer_text_field" rows="7"></textarea>--%>
        <%--<button id="post_answer_button">${post}</button>--%>
    </div>
</div>
</body>
</html>
