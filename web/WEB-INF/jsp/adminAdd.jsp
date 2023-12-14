<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <!-- Форма добавления -->
    <h2><fmt:message key="label.addingPatient" /></h2>
    <form action="AddServlet" method="post">
        <label for="surname"><fmt:message key="label.surname" /></label>
        <input type="text" name="surname" required><br>

        <label for="name"><fmt:message key="label.name" /></label>
        <input type="text" name="name" required><br>

        <label for="patronymic"><fmt:message key="label.patronymic" /></label>
        <input type="text" name="patronymic" required><br>

        <label for="address"><fmt:message key="label.address" /></label>
        <input type="text" name="address" required><br>

        <label for="phone"><fmt:message key="label.phone" /></label>
        <input type="text" name="phone" required><br>

        <label for="cardNumber"><fmt:message key="label.cardNumber" /></label>
        <input type="number" name="cardNumber" required><br>

        <label for="diagnosis"><fmt:message key="label.diagnosis" /></label>
        <input type="text" name="diagnosis" required><br>

        <label for="age"><fmt:message key="label.age" /></label>
        <input type="number" name="age" required><br>

        <input type="submit" value="<fmt:message key="button.add" />">
    </form>

    <form action="page" method="post">
        <input type="hidden" name="page" value="toAdmin">
        <input type="submit" value="<fmt:message key="button.toHomepage" />">
    </form>  
</body>
    </fmt:bundle>

</html>
