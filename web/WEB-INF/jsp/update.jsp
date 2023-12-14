<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.localization.messages.msg">
    <style>
        <%@include file="/resources/css/logincss.css"%>
    </style>
</head>
<body>
    <h2><fmt:message key="update.patient.title" /></h2>
    
    <form action="UpdateServlet" method="post">
        <c:forEach var="patient" items="${patient}">

        <label for="name"><fmt:message key="name.label" /></label>
        <input type="text" name="name" value="${patient.name}" required><br>
        
        <label for="surname"><fmt:message key="surname.label" /></label>
        <input type="text" name="surname" value="${patient.surname}" required><br>
        
        <label for="patronymic"><fmt:message key="patronymic.label" /></label>
        <input type="text" name="patronymic" value="${patient.patronymic}" required><br>
        
        <label for="address"><fmt:message key="address.label" /></label>
        <input type="text" name="address" value="${patient.address}" required><br>
        
        <label for="phone"><fmt:message key="phone.label" /></label>
        <input type="text" name="phone" value="${patient.phone}" required><br>
        
        <label for="cardNumber"><fmt:message key="cardNumber.label" /></label>
        <input type="text" name="cardNumber" value="${patient.cardNumber}" required><br>
        
        <label for="diagnosis"><fmt:message key="diagnosis.label" /></label>
        <input type="text" name="diagnosis" value="${patient.diagnosis}" required><br>
        
        <label for="age"><fmt:message key="age.label" /></label>
        <input type="text" name="age" value="${patient.age}" required><br>
        
        <input type="hidden" name="id" value="${patient.id}">
        
        <input type="submit" value="<fmt:message key="update.button" />">
        </c:forEach>
    </form>
    
    <form action="page" method="post">
        <input type="hidden" name="page" value="toAdmin">
        <input type="submit" value="<fmt:message key="toHomepage.button" />">
    </form>  
</body>
</fmt:bundle>
</html>
