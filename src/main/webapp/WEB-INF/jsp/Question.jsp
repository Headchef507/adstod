<!DOCTYPE html>

<%@ page pageEncoding="utf-8" errorPage="errorHandler.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

    <head>
        <title>Question</title>

        <link rel="stylesheet" href="<c:url value="/css/Question.css"/>"/>
        <script src="<c:url value="/js/Question.js" />"></script>
    </head>
    <body>

    <h1><a href="/Question">Question</a></h1>

    <%--Note that the `commandName` given here HAS TO MATCH the name of the attribute--%>
    <%--that is added to the model that is passed to the view.--%>
    <%--See PostitNoteController, method postitNoteViewGet(), and find where this attribute is added to the model.--%>
    <sf:form method="POST" modelAttribute="Question" action="/question">

        <sf:label path="questionText" type="text"/>

        <p>${Question.questionText}</p>

        <c:forEach var="counter" begin="0" end="${fn:length(Question.answerOptions)-1}">
            <input type="radio" name="rb" value="${counter}"/> ${Question.answerOptions[counter]}
        </c:forEach>

    </sf:form>

    </body>
</html>
