<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:bundle basename="language" prefix="answer.">
    <fmt:message key="like" var="like"/>
</fmt:bundle>

<div class="answer_element">
    <div class="answer_element_author_line">
        <button class="answer_element_author_button"><img src="/avatar.png"/>${answer.login}</button>
    </div>
    <div class="answer_text_area">
        <p>${answer.textAnswer}</p>
    </div>
    <button class="unpressed_like_answer_button">${like} ${answer.likes}</button>
</div>