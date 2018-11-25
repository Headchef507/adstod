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

        <table>
            <tr>
                <%--td> Name:</td--%>
                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                <td><sf:label path="questionText" type="text"/></td>
            </tr>
            <%--tr>
                <td>Notes:</td>
                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                <%--td><sf:textarea path="note" type="text" placeholder="Note text here"/></td>
            </tr--%>
        </table>

        <c:forEach var="counter" begin="0" end="${fn:length(Question.answerOptions)-1}">
            <input type="radio" name="rb"/> ${Question.answerOptions[counter]}
        </c:forEach>

    </sf:form>



    <%--Choose what code to generate based on tests that we implement--%>
    <%--c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <%--c:when test="${not empty postitNotes}">
            <%--Create a table for the Postit Notes--%>
            <table class="notes">

                <%--For each postit note, that is in the list that was passed in the model--%>
                <%--generate a row in the table--%>
                <%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
                <%--c:forEach var="questionText" items="${questions}">
                    <tr>
                        <%--We can reference attributes of the Entity by just entering the name we gave--%>
                        <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                        <%--Create a link based on the name attribute value--%>
                        <td>${Question.questionText}</td>
                        <%--The String in the note attribute--%>
                        <%--td>${postit.note}</td--%>
                    </tr>
                <%--/c:forEach--%>
            </table>
        <%--/c:when--%>

        <%--If all tests are false, then do this--%>
        <%--c:otherwise>
            <h3>No notes!</h3>
        </c:otherwise>
    <%--/c:choose--%>

    </body>
</html>
