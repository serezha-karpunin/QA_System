<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="language">
    <fmt:message key="options_menu.profile" var="profile"/>
    <fmt:message key="options_menu.settings" var="settings"/>
    <fmt:message key="options_menu.logout" var="logout"/>
    <fmt:message key="header.search_placeholder" var="search_placeholder"/>
    <fmt:message key="header.ask" var="ask"/>
    <fmt:message key="header.yes" var="yes"/>
    <fmt:message key="header.no" var="no"/>
    <fmt:message key="question_form.title_placeholder" var="title"/>
    <fmt:message key="question_form.text_placeholder" var="text"/>
    <fmt:message key="question_form.ask_question" var="ask_question"/>
    <fmt:message key="question_form.tags_placeholder" var="tags"/>
    <fmt:message key="question_form.question_error" var="question_error"/>
    <fmt:message key="question.delete_question" var="delete_question"/>
    <fmt:message key="question.confirm_question_deletion" var="confirm_question_deletion"/>
    <fmt:message key="answer.confirm_answer_deletion" var="confirm_answer_deletion"/>

</fmt:bundle>
<div id="mask"></div>

<div id="question_form_wrapper">
    <button id="question_form_close_button"><img src="/icons/cross.png"/></button>
    <form id="question_form" action="/add_question" method="post">
        <input id="question_form_title_field" name="title" type="text" placeholder="${title}">
        <br>
        <textarea id="question_form_text_area" rows="7" name="text" placeholder="${text}"></textarea>
        <br>
        <input id="question_form_tags_field" name="tags" type="text" placeholder="${tags}">
        <br>
        <div id="question_form_down_panel">
            <p id="question_form_error_message">${question_error}</p>
            <button>${ask_question}</button>
        </div>
    </form>
</div>

<div id="confirm_question_deletion_form_wrapper">
    <p>${confirm_question_deletion}</p>
    <div class="confirm_deletion_form_buttons_line">
        <form action="/delete_question" method="post">
            <button>${yes}</button>
        </form>
        <button class="confirm_deletion_close_button">${no}</button>
    </div>
</div>

<div id="confirm_answer_deletion_form_wrapper">
    <p>${confirm_answer_deletion}</p>
    <div class="confirm_deletion_form_buttons_line">
        <form action="/delete_answer" method="post">
            <button>${yes}</button>
        </form>
        <button class="confirm_deletion_close_button">${no}</button>
    </div>
</div>

<div id="main_header_background">
    <div id="main_header_content">
        <div id="main_header_left_part">
            <form action="/">
                <button id="home_button"><img src="/icons/home.png"/></button>
            </form>
        </div>
        <div id="main_header_center_part">
            <form action="/search" method="post">
                <input id="search_box" type="text" name="searchString" placeholder="${search_placeholder}"/>
            </form>
        </div>
        <div id="main_header_right_part">
            <button id="auth_header_call_options_menu_button"><img src="/avatar.png"/></button>
            <button id="auth_header_ask_question_button">${ask}</button>
        </div>
    </div>
    <div id="options_menu">
        <div id="options_menu_arrow" class="arrow-up"></div>
        <span>${userLogin}</span>
        <form action="/user_profile" method="post">
            <button id="auth_header_menu_profile_button" name="visitedUser" value="${userLogin}">${profile}</button>
        </form>

        <form action="/user_settings" method="post">
            <button id="auth_header_menu_settings_button">${settings}</button>
        </form>

        <form action="/logout" method="post">
            <button id="auth_header_menu_logout_button">${logout}</button>
        </form>

    </div>

</div>
