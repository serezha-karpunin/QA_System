<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel='stylesheet' href='/css/main_css.css'>
</head>
<body>
<div id="page_wrapper">
    <%@include file="/jsp/headers/unauth_main_header.jsp" %>
    <h1> registry </h1>
    <form action="/registration" method="post">
        <fieldset>
            <input id="login_field" name="login" type="text" placeholder="login">
            <input id="email_field" name="email" type="text" placeholder="email">
            <input id="password_field" name="password" type="text" placeholder="password">
            <input id="confirm_password_field" name="confirm_password" type="text" placeholder="confirm password">
            <button>confirm</button>
        </fieldset>
    </form>
</div>
</body>
</html>


