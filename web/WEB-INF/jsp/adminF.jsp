<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.localization.messages.msg">
       <style>
            <%@include file="/resources/css/logincss.css"%>
        </style>
</head>
<body>
<div class="signin-form">

    <ul class="nav-menu">
        <li>
            <a href="AddServlet" method="post">
                <i class="fas fa-plus"></i> <fmt:message key="addPatient" />
            </a>
        </li>
        <li>
            <a href="ReadServlet">
                <i class="fas fa-user"></i> <fmt:message key="readPatient" />
            </a>
        </li>
    </ul>
                    
                    <form action="page" method="post">
            <input type="hidden" name="page" value="toLogin">
            <input type="submit" value="<fmt:message key="toHomepage" />">
        </form>  
</div>
</body>
</fmt:bundle>
</html>
