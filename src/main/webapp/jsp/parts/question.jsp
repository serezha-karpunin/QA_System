<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="language" prefix="question.">
    <fmt:message key="answers" var="answers"/>
    <fmt:message key="views" var="views"/>

</fmt:bundle>

<div class="question_element">
    <div class="question_element_left_part">
        <a href="/question_page?id=${question.idQuestion}"><h3>${question.title}</h3></a>
        <div class="question_element_down_panel">
            <div class="tags">
                <c:forEach var="tag" items="${question.tags}">
                    <button>${tag}</button>
                </c:forEach>
                <%--<h5>c++</h5>--%>
            </div>
            <h5>${question.date}</h5>
            <button>${question.login}</button>
        </div>
    </div>
    <div class="question_element_right_part">
        <a href="/question_page?id=${question.idQuestion}">${question.answers}<br>${answers}</a>
        <a href="/question_page?id=${question.idQuestion}">${question.views}<br>${views}</a>
            <%--<button>${question.answers}<br>${answers}</button>--%>
            <%--<button>${question.views}<br>${views}</button>--%>
        </form>
    </div>
</div>
