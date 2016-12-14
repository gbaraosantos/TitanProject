<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfAuthenticationStrategy.SaveOnAccessCsrfToken"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Titan Project</title>
    </head>

    <body>
        <h1> 1: Hello World! </h1>

        <form:form action="/upload?${_csrf.parameterName}=${_csrf.token}"  method="POST" enctype="multipart/form-data">
            <input type="file" name="testFile"/>
            <button type="submit" value="Upload">Log in!</button>
        </form:form>
    </body>
</html>
