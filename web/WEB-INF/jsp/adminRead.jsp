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
    <!-- Таблица с абитуриентами -->
    <table>
        <thead>
            <th><fmt:message key="name" /></th>
            <th><fmt:message key="surname" /></th>
            <th><fmt:message key="patronymic" /></th>
            <th><fmt:message key="address" /></th>
            <th><fmt:message key="phone" /></th>
            <th><fmt:message key="cardNumber" /></th>
            <th><fmt:message key="diagnosis" /></th>
            <th><fmt:message key="age" /></th>
            <th><fmt:message key="delete" /></th>
            <th><fmt:message key="edit" /></th>
        </thead>
        <c:forEach var="patient" items="${patient}">
            <tr>
                <td>${patient.name}</td>
                <td>${patient.surname}</td>
                <td>${patient.patronymic}</td>
                <td>${patient.address}</td>
                <td>${patient.phone}</td>
                <td>${patient.cardNumber}</td>
                <td>${patient.diagnosis}</td>
                <td>${patient.age}</td>
                <td>
                    <form action="DeleteServlet" method="post">
                        <input type="hidden" name="id" value="${patient.id}"/>
                        <input type="submit" value="<fmt:message key="delete" />"/>
                    </form>
                </td>
                <td>
                    <form action="UpdateServlet">
                        <input type="hidden" name="id" value="${patient.id}"/>
                        <input type="submit" value="<fmt:message key="edit" />"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="page" method="post">
        <input type="hidden" name="page" value="toAdmin">
        <input type="submit" value="<fmt:message key="toHomepage" />">
    </form>
</body>
</fmt:bundle>
</html>
