<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel='stylesheet' href='/css/main_style.css'>
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

</fmt:bundle>
<%@include file="/jsp/headers/auth_main_header.jsp" %>
<div id="page_wrapper">
    <div id="question_page_content_wrapper">
        <div id="question_page_author_line">
            <button id="question_page_author_button"><img src="/avatar.png"/>username</button>
        </div>
        <div id="question_page_theme_line">
            <h2>Question theme here</h2>
        </div>
        <div id="question_text_area">
            <p>Question text here here here Question text here here hereQuestion text here here hereQuestion text here
                here hereQuestion text here here hereQuestion text here here here</p>
        </div>
        <div id="question_page_tags_line">
            <div class="tags">
                <h5>java</h5>
                <h5>c++</h5>
            </div>
        </div>

        <h3>${answers}</h3>

        <%@include file="/jsp/parts/answer.jsp" %>
        <%@include file="/jsp/parts/answer.jsp" %>

        <br>
        <h3>${your_answer}</h3>
        <textarea id="answer_text_field" rows="7"></textarea>
        <button id="post_answer_button">${post}</button>
    </div>
</div>
</body>
</html>
