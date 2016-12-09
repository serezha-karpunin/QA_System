<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
    <link rel='stylesheet' href='/css/main_style.css'>
    <script src='/js/jquery-3.1.1.js'></script>
    <script src='/js/header_functions.js'></script>
    <script src='/js/page_functions.js'></script>

</head>
<body>
<fmt:setLocale value="en"/>

<%@include file="/jsp/headers/auth_main_header.jsp" %>

<fmt:bundle basename="language" prefix="main_page.">
    <fmt:message key="title" var="title"/>
    <fmt:message key="last_questions_tab" var="last"/>
    <fmt:message key="intresting_questions_tab" var="interesting"/>
    <fmt:message key="subcribtion_tab" var="subscription"/>
</fmt:bundle>
<div id="page_wrapper">
    <div id="main_page_title_and_tabs">
        <h2>${title}</h2>
        <div class="tabs">
            <input id="tab_last" type="radio" name="tabs">
            <label for="tab_last">${last}</label>

            <input id="tab_interest" type="radio" name="tabs">
            <label for="tab_interest">${interesting}</label>

            <input id="tab_sub" type="radio" name="tabs">
            <label for="tab_sub">${subscription}</label>
        </div>
    </div>
    <section id="last_content">
        <%@include file="/jsp/parts/question.jsp" %>
        <%@include file="/jsp/parts/question.jsp" %>
    </section>
    <section id="interesting_content">
        <p>
            empty
        </p>
    </section>
    <section id="subscription_content">
        <p>
            empty
        </p>
    </section>



</div>
</body>
</html>

