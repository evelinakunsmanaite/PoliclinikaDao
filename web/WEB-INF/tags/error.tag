<%@tag language="java" pageEncoding="UTF-8" %>
<%@ tag body-content="empty" %>
<!--%@ attribute name="result" required="false" type="errors.UserValidationError" %-->
<%@ taglib prefix="f" uri="/WEB-INF/tlds/check" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${result != null}">
    <fmt:bundle basename="com.localization.messages.msg">
        <c:set var="errors" value="${f:getErrors(result)}" />
        <c:choose>
            <c:when test="${fn:length(errors.errorList) > 0}">
                <c:set var="errorList" value="${errors.errorList}" /> 
                <p style="color: red">
                    <c:forEach var="error" items="${errorList}">
                        <fmt:message key = "${error}"/><br/>
                    </c:forEach>
                </p>
            </c:when>
            <c:otherwise>
                <p style="color: green">
                    <fmt:message key = "save.success"/>
                </p>
            </c:otherwise>
        </c:choose>
    </fmt:bundle>    
</c:if>