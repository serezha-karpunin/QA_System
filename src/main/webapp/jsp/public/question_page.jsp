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
    <script src='/js/question_page_functions.js'></script>
    <script src='/js/answer_element_functions.js'></script>
</head>
<body>
<fmt:bundle basename="language" prefix="question_page.">
    <fmt:message key="answers" var="answers"/>
    <fmt:message key="your_answer" var="your_answer"/>
    <fmt:message key="post_answer" var="post"/>
    <fmt:message key="call_auth" var="call_auth"/>
    <fmt:message key="views" var="views"/>

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
            <form action="/user_profile" method="post">
                <button id="question_page_author_button" name="visitedUser" value="${questionBean.login}"><img src="/avatar.png"/>${questionBean.login}</button>
            </form>
            <div>
                <p>${questionBean.date}</p>
                <p>${questionBean.views} ${views}</p>
            </div>


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
            <c:if test="${questionBean.login eq userLogin}">
                <button class="delete_question_button" value="${questionBean.idQuestion}">${delete_question}</button>
            </c:if>
        </div>

        <h3>${answers}</h3>


        <div id="answers_area"></div>

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
