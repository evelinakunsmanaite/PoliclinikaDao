<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "err" tagdir="/WEB-INF/tags" %>


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
    <h1 align="center"><fmt:message key="login.title" /></h1>
    <p align="center"><fmt:message key="login.description" /></p>
              <err:error />

    <form action="LoginServlet" method="post" align="center"> 
        <label><fmt:message key="login.label.login" />&nbsp;&nbsp;</label>
        <input type="text" size="30%" name="login"/><br/>
        <br>
        <label><fmt:message key="login.label.password" /></label>
        <input type="password" size="30%" name="pass"/><br/>
        <br>
        <br> 
                <input class="b" type="submit" id="inp" value="<fmt:message key="login" />"> <!-- Кнопка отправки формы -->

    </form>

   

     <table>
                    <tr>
                        <td>
                            <form action="LocalServlet"> 
                                <div class="form-group form-button">
                                    <input type="hidden" name="locale" value="en"/>
                                    <input class="form-submit" type="submit" value='<fmt:message key = "en" />'/>
                                </div>
                            </form> 
                        </td>
                        <td>

                            <form action="LocalServlet"> 
                                <div class="form-group form-button">
                                    <input type="hidden" name="locale" value="ru"/>
                                    <input class="form-submit"  type="submit" name="locale" value='<fmt:message key = "ru" />'/>
                                </div>
                            </form>
                        </td>
                    </tr>
                </table> 
</body>
</fmt:bundle>
</html>
