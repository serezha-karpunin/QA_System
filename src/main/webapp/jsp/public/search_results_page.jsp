<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel='stylesheet' href='/css/base_n_headers.css'>
    <link rel='stylesheet' href='/css/question.css'>
    <link rel='stylesheet' href='/css/search_results.css'>
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

<fmt:bundle basename="language" prefix="search_results.">
    <fmt:message key="title" var="title"/>
    <fmt:message key="nothing" var="nothing"/>
</fmt:bundle>
<div id="page_wrapper">
    <div id="search_results_page_content_wrapper">
        <h2 class="title_text">${title}</h2>
        <c:if test="${searchResults == null}">
            <div>${nothing}</div>
        </c:if>
        <c:forEach var="question" items="${searchResults}">
            <%@include file="/jsp/parts/question.jsp" %>
        </c:forEach>
    </div>
</div>
</body>
</html>