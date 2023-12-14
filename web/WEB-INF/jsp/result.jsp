<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        <%@include file="/resources/css/logincss.css"%>
    </style>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.localization.messages.msg">
</head>
<body>
    
    
            <table align="center">
                <thead align="center">
                    <th><fmt:message key="table.column.surname" /></th>
                    <th><fmt:message key="table.column.name" /></th>
                    <th><fmt:message key="table.column.patronymic" /></th>
                    <th><fmt:message key="table.column.address" /></th>
                    <th><fmt:message key="table.column.phone" /></th>
                    <th><fmt:message key="table.column.cardNumber" /></th>
                    <th><fmt:message key="table.column.diagnosis" /></th>
                    <th><fmt:message key="table.column.age" /></th>
                </thead>
                <c:forEach var="pa" items="${result}">
                    <tr align="center">
                        <td>${pa.surname}</td>
                        <td>${pa.name}</td>
                        <td>${pa.patronymic}</td>
                        <td>${pa.address}</td>
                        <td>${pa.phone}</td>
                        <td>${pa.cardNumber}</td>
                        <td>${pa.diagnosis}</td>
                        <td>${pa.age}</td>
                    </tr>
                </c:forEach>
            </table>
          
     <form action="page" method="post">
            <input type="hidden" name="page" value="toUser">
            <input type="submit" value="<fmt:message key="toHomepage" />">
        </form>  
</body>
</fmt:bundle>
</html>
