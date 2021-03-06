<!DOCTYPE html>

<%@ page pageEncoding="utf-8" errorPage="errorHandler.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
    <title>Results</title>

    <link rel="stylesheet" href="<c:url value="/css/Result.css"/>"/>
</head>
<body>

<h1>Results</h1>

<sf:form method="GET" modelAttribute="Resources">

    <%-- Gets and shows the results --%>
    <c:forEach var="counter" begin="0" end="${fn:length(Resources)-1}">
        <p>${Resources.get(counter).getTitle()}</p><br/>
        <a href="${Resources.get(counter).getLink()}">${Resources.get(counter).getLink()}</a><br/>
        <p>${Resources.get(counter).getDescription()}</p><br/>
    </c:forEach>

</sf:form>

</body>
</html>
