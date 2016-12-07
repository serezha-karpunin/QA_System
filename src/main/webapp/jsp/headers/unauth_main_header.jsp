<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="language">
    <fmt:message key="authmenu.email_login" var="auth_email_login"/>
    <fmt:message key="authmenu.error" var="auth_error"/>
    <fmt:message key="authmenu.password" var="auth_password"/>
    <fmt:message key="authmenu.registration" var="auth_registration"/>
    <fmt:message key="authmenu.signin" var="signin"/>
    <fmt:message key="header.search_placeholder" var="search_placeholder"/>
</fmt:bundle>

<div id="main_header_background">
    <div id="main_header_content">
        <div id="main_header_left_part">
            <form action="/">
                <button id="home_button"><img src="/icons/home.png"/></button>
            </form>
        </div>
        <div id="main_header_center_part">
            <input id="search_box" type="text" placeholder="${search_placeholder}"/>
        </div>
        <div id="main_header_right_part">
            <button id="call_login_menu_button">${signin}</button>
            <div id="login_menu">
                <div class="arrow-up"></div>
                <form id="login_form" action="/login" method="post">
                    <input id="auth_email_field" name="login" type="text" placeholder="${auth_email_login}">
                    <br>

                    <input id="auth_password_field" name="password" type="text" placeholder="${auth_password}">
                    <br>

                    <button id="complete_login_button">${signin}</button>
                </form>
                <form action="/jsp/auth/registration.jsp" method="get">
                    <button id="call_registration_page_button">${auth_registration}</button>
                </form>
            </div>
        </div>


    </div>

</div>

