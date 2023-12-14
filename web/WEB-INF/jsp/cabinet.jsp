<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <style>
        <%@include file="/resources/css/logincss.css"%>
    </style>
    <meta charset="UTF-8">  
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.localization.messages.msg">
</head>
<body>
      <form action="page" method="post">
            <input type="hidden" name="page" value="toLogin">
            <input type="submit" value="<fmt:message key="toHomepage" />">
        </form>  

    <h1 align="center"><fmt:message key="welcome.message"/><%= session.getAttribute("name")%></h1>
    <br>

    <div class="form-block" align="center">
        <form action="fullServlet" method="get" align="center">
            <h2 align="center"><fmt:message key="full.list" /></h2>
            <button class="b" type="submit"><fmt:message key="find.button" /></button>
        </form>
    </div>

    <div class="form-block" align="center">
        <form action="diagnosisServlet" method="get" align="center">
            <h2 align="center"><fmt:message key="search.diagnosis" /></h2>
            <label align="center"><fmt:message key="diagnosis.label" />: <input type="text" name="diagnosis" required=""></label>
            <button class="b" type="submit" ><fmt:message key="find.button" /></button>
        </form>
    </div>

    <div class="form-block">
        <form action="srchServlet" method="post" align="center">
            <h2 align="center"><fmt:message key="search.by.card.number" /></h2>
            <label><fmt:message key="from.label" />: <input type="number" name="start" required=""></label>
            <label><fmt:message key="to.label" />: <input type="number" name="end" required=""></label>
            <button class="b" type="submit"><fmt:message key="find.button" /></button>
        </form>
    </div>

    <div class="form-block">
        <form action="ageServlet" method="post" align="center">
            <h2 align="center"><fmt:message key="search.by.age" /></h2>
            <label><fmt:message key="age.label" />: <input type="number" name="age" required=""></label>
        </form>
   
    </div>
    <br>
</body>
 </fmt:bundle>
</html>
