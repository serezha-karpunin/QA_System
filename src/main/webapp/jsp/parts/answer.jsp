<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="en"/>
<fmt:bundle basename="language" prefix="answer.">
    <fmt:message key="like" var="like"/>
</fmt:bundle>

<div class="answer_element">
    <div class="answer_element_author_line">
        <form action="/user_profile" method="post">
            <button name="visitedUser" value="${answer.login}" class="answer_element_author_button"><img src="/avatar.png"/>${answer.login}</button>
        </form>
        <p>${answer.date}</p>
    </div>
    <div class="answer_text_area">
        <p>${answer.textAnswer}</p>
    </div>
    <%--<div>--%>
    <c:choose>
        <c:when test="${(empty userLogin)}">
            <div id="answer_like_line">
                <button class="not_active_like_answer_button" value="${answer.idAnswer}">${like}</button>
                <p class="number_of_likes">${answer.likes}</p></div>
        </c:when>
        <c:when test="${answer.isLikedByCurrentUser}">
            <div id="answer_like_line">
                <button class="pressed_like_answer_button" value="${answer.idAnswer}">${like}</button>
                <p class="number_of_likes">${answer.likes}</p></div>
        </c:when>
        <c:when test="${not answer.isLikedByCurrentUser}">
            <div id="answer_like_line">
                <button class="unpressed_like_answer_button" value="${answer.idAnswer}">${like}</button>
                <p class="number_of_likes">${answer.likes}</p></div>
        </c:when>
        <%--</div>--%>
        <%--<c:otherwise>--%>
        <%--<button class="unpressed_like_answer_button">${like} ${answer.likes}</button><b>${answer.likes}</b>--%>
        <%--</c:otherwise>--%>
    </c:choose>


</div>