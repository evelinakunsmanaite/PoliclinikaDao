<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="resources/css/errorcss.css" rel="stylesheet" />
    
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.localization.messages.msg">

</head>
<body>
    <div class="error-container">
        <h1>
            <fmt:message key="error">
                <fmt:param value="${pageContext.exception.message}"/>
            </fmt:message>
        </h1>
        <h2>
            <fmt:message key="error.code">
                <fmt:param value="${pageContext.errorData.statusCode}"/>
            </fmt:message>
        </h2>
        <h3>
            <fmt:message key="error.name">
                <fmt:param value="${pageContext.exception.getClass().getName()}"/>
                <fmt:param value="${pageContext.errorData.requestURI}"/>
            </fmt:message>
        </h3>
        <form action="index.html">
            <input type="submit" class="submit" value='<fmt:message key="to.main"/>'/>
        </form>
    </div>
</body>
</fmt:bundle>
</html>
