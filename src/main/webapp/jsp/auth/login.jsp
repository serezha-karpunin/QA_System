<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel='stylesheet' href='/css/main_css.css'>
    <script src='/js/jquery-3.1.1.js'></script>
    <script src='/js/validator.js'></script>
</head>
<body>
<fmt:setLocale value="en"/>

<fmt:bundle basename="language" prefix="registration.">
    <fmt:message key="login" var="login"/>

</fmt:bundle>

<div id="page_wrapper">
    <%@include file="/jsp/headers/unauth_main_header.jsp" %>
    ${errorLogin}
    ${sessionScope.userLogin}
    ${param.errorLogin.toString()}
    <div class="text_field_list">
        <form id="login_form" action="/login" method="post">
            <input id="login_field" name="login" type="text" placeholder="${login}">
            <br>
            <input id="password_field" name="password" type="text" placeholder="Create a password">
            <br>
            <button>Complete Sign-Up</button>

        </form>
    </div>
</div>

</body>
</html>
