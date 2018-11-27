<!DOCTYPE html>

<%@ page pageEncoding="utf-8" errorPage="errorHandler.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

    <head>
        <title>ADSTOD</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
    </head>
    <body>
        <h1>Adstod</h1>

        <p>Veldu tungumál/Select a language/Wybierz język</p>
        <ul>
            <li><a href="/Question?lang=ICE">Íslenska</a></li>
            <li><a href="/Question?lang=ENG">English</a></li>
            <li><a href="/Question?lang=POL">Polskie</a></li>
        </ul>
    </body>
</html>
