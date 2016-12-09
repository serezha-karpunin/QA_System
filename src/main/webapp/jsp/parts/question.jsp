<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="language" prefix="question.">
<fmt:message key="answers" var="answers"/>
<fmt:message key="views" var="views"/>

</fmt:bundle>

<div class="question_element">
    <div class="question_element_left_part">
        <h3>Hello how are you?Hello how are you? Hello how are you? Hello how are you? Hello how are you?</h3>
        <div class="question_element_down_panel">
            <div class="tags">
                <h5>java</h5>
                <h5>c++</h5>
            </div>
            <h5>username</h5>
        </div>
    </div>
    <div class="question_element_right_part">
        <button><h2>5</h2><h4>${answers}</h4></button>
        <button><h2>26</h2><h4>${views}</h4></button>
    </div>
</div>
