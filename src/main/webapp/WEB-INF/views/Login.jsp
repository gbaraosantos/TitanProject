<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfAuthenticationStrategy.SaveOnAccessCsrfToken"--%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
    <head>

    </head>

    <body>
        <form role="form" action="<c:url value="/loginForm"/>" method="post" class="login-form">
            <input placeholder="E-mail" name="email" type="text" id = "email">
            <input placeholder="Password" name="password" type="password" id = "password">
            <button type="submit">Log in!</button>


            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

    </body>


</html>