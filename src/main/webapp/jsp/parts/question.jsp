<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="language" prefix="question.">
    <fmt:message key="answers" var="answers"/>
    <fmt:message key="views" var="views"/>

</fmt:bundle>

<div class="question_element">
    <div class="question_element_left_part">
        <a href="/jsp/public/question_page.jsp?id=${question.idQuestion}"><h3>${question.title}</h3></a>
        <div class="question_element_down_panel">
            <div class="tags">
                <c:forEach var="tag" items="${question.tags}">
                    <button>${tag}</button>
                </c:forEach>
                <%--<h5>c++</h5>--%>
            </div>
            <h5>${question.date}</h5>
            <h5>${question.login}</h5>
        </div>
    </div>
    <div class="question_element_right_part">
        <button><h2>${question.answers}</h2><h4>${answers}</h4></button>
        <button><h2>${question.views}</h2><h4>${views}</h4></button>
    </div>
</div>
