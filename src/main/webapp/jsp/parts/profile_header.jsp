<fmt:bundle basename="language" prefix="profile.">
    <fmt:message key="registration_date" var="date"/>
    <fmt:message key="questions_label" var="questions_label"/>
    <fmt:message key="answers_label" var="answers_label"/>
</fmt:bundle>

<div id="profile_page_user_panel">
    <img id="avatar" src="/avatar.png">
    <div id="profile_page_user_info">
        <h2 class="title_text">${userBean.login}</h2>
        <p>${date}: ${userBean.registrationDate}</p>
    </div>
    <div class="profile_page_user_stat">
        <b>${userBean.questionCount}</b><br><p>${questions_label}</p>
    </div>
    <div class="profile_page_user_stat">
        <b>${userBean.answerCount}</b><br><p>${answers_label}</p>
    </div>
</div>
