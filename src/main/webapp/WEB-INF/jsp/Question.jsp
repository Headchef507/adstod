<!DOCTYPE html>

<%@ page pageEncoding="utf-8" errorPage="errorHandler.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

    <head>
        <title>Question ${Question.id}</title>

        <link rel="stylesheet" href="<c:url value="/css/Question.css"/>"/>
        <script src="<c:url value="/js/Question.js" />"></script>
    </head>
    <body>

    <h1>Question ${Question.id}</h1>

    <sf:form method="GET" modelAttribute="Question">

        <p>${Question.questionText}</p>

        <c:forEach var="counter" begin="0" end="${fn:length(Question.answerOptions)-1}">
            <input type="radio" name="answer" value="${counter+1}" onclick="enableNextButton()"> ${Question.answerOptions[counter]}
        </c:forEach>

        <c:if test="${Question.id > 1}">
            <INPUT TYPE="submit" id="previous" VALUE="PREVIOUS" onclick="form.action='/PrevQuestion'">
        </c:if>

        <c:choose>
            <c:when test="${Question.id == QuestionCount}">
                <INPUT TYPE="submit" id="finish" disabled="disabled" VALUE="FINISH" onclick="form.action='/Results'">
            </c:when>
            <c:otherwise>
                <INPUT TYPE="submit" id="next" disabled="disabled" VALUE="NEXT" onclick="form.action='/NextQuestion'">
            </c:otherwise>
        </c:choose>


    </sf:form>

    </body>
</html>
