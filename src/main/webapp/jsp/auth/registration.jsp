<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel='stylesheet' href='/css/main_css.css'>
    <script src='/js/validator.js'></script>
</head>
<body>
<div id="page_wrapper">
    <%--<%@include file="/jsp/headers/unauth_main_header.jsp" %>--%>

    <div class="text_field_list">
        <form action="/registration" method="post">

                <input id="email_field" name="email" type="text" placeholder="Your email address" ><br>
                <%--<h6>only letters</h6>--%>
                <input id="login_field" name="login" type="text" placeholder="Create a login" ><br>
                <input id="password_field" name="password" type="text" placeholder="Create a password" ><br>
                <input id="confirm_password_field" name="confirm_password" type="text" placeholder="Confirm password"><br>
                <button>Complete Sign-Up</button>
                ${param.login}

        </form>
    </div>
</div>
</body>
</html>


