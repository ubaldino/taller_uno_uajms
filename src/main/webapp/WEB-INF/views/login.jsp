<%-- 
    Document   : login
    Created on : 17-sep-2017, 11:16:06
    Author     : ubaldino
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@include file="head.jsp"%>
    </head>
    <body>
        
        <form:form id="loginForm" method="post" action="/login" modelAttribute="loginBean" >
            <form:label path="login">Ingrese usuario</form:label>
            <form:input id="login" name="login" path="login" /><br>
            <form:label path="password">Ingrese contraseña</form:label>
            <form:password id="password" name="password" path="password" /><br>
            <input type="submit" value="Submit" />
        </form:form>
    </body>
</html>
