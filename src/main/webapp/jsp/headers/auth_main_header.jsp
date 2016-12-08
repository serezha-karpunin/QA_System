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
            <button id="auth_header_call_options_menu_button"><img src="avatar.png" style="width:30px"/></button>
            <button id="auth_header_ask_question_button">ask</button>
        </div>
    </div>
    <div id="options_menu">
        <div id="options_menu_arrow" class="arrow-up"></div>
        <span>username</span>
        <form action="" method="post">
            <button id="auth_header_menu_profile_button">profile</button>
        </form>
        <form action="" method="post">
            <button id="auth_header_menu_questions_button">messages</button>
        </form>
        <form action="" method="post">
            <button id="auth_header_menu_settings_button">settings</button>
        </form>
        <form action="" method="post">
            <button id="auth_header_menu_logout_button">logout</button>
        </form>

    </div>

</div>
