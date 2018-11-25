<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*" %>

<%
    Date createTime = new Date(session.getCreationTime());
    Date lastAccessTime = new Date(session.getLastAccessedTime());

    String title = "Welcome Back";
    Integer visitCount = 0;
    String visitCountKey = "visitCount";
    String userIDKey = "userID";
    String userID = "Dickbutt";

    if (session.isNew()){
        session.setAttribute(userIDKey, userID);
        session.setAttribute(visitCountKey,  visitCount);
    }
    visitCount = (Integer)session.getAttribute(visitCountKey);
    visitCount = visitCount + 1;
    userID = (String)session.getAttribute(userIDKey);
    session.setAttribute(visitCountKey,  visitCount);
%>

<html lang="en">

    <head>
        <title>ADSTOD</title>
    </head>
    <body>

    id:<% out.print( session.getId()); %><br/>
    Creation Time:<% out.print(createTime); %><br/>
    Time of Last Access:<% out.print(lastAccessTime); %><br/>
    User ID:<% out.print(userID); %><br/>
    Number of visits:<% out.print(visitCount); %><br/>


    <h1>Adstod</h1>

    <p>Insert languages here</p>

    <ul>
        <%-- það var posti á þessum stað--%>
        <li><a href="/question">Click here for Persistence Layer Demo</a></li>
    </ul>
    </body>
    <footer>ASDF</footer>
</html>
