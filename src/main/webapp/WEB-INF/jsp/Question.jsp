<!DOCTYPE html>

<%@ page pageEncoding="utf-8" errorPage="errorHandler.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${Language}"/>
<fmt:setBundle basename="messages"/>

<html>

    <head>
        <title><fmt:message key="label.question"/> ${Question.id}</title>

        <link rel="stylesheet" href="<c:url value="/css/Question.css"/>"/>
        <script src="<c:url value="/js/Question.js" />"></script>
    </head>
    <body>

        <h1><fmt:message key="label.question"/> ${Question.id}</h1>

        <%-- Form for question answering --%>
        <sf:form method="GET" modelAttribute="Question">

            <%-- Question text --%>
            <p>${Question.questionText}</p>

            <div class="radio-button">
                <%-- Add a radio button for each answer option --%>
                <c:forEach var="counter" begin="0" end="${fn:length(Question.answerOptions)-1}">
                    <input type="radio" name="answer" value="${counter+1}" onclick="enableNextButton()"> ${Question.answerOptions[counter]}
                </c:forEach>
            </div>

            <%-- Don't have a previous button on the first question --%>
            <c:if test="${Question.id > 1}">
                <INPUT TYPE="submit" id="previous" VALUE=<fmt:message key="label.previous"/> onclick="form.action='/PrevQuestion'">
            </c:if>

            <%-- Replaces next button with finish button on the last question --%>
            <c:choose>
                <c:when test="${Question.id == QuestionCount}">
                    <INPUT TYPE="submit" id="next" disabled="disabled" VALUE="FINISH" onclick="form.action='/Results'">
                </c:when>
                <c:otherwise>
                    <INPUT TYPE="submit" id="next" disabled="disabled" VALUE=<fmt:message key="label.next"/> onclick="form.action='/NextQuestion'">
                </c:otherwise>
            </c:choose>
        </sf:form>

    </body>
</html>
