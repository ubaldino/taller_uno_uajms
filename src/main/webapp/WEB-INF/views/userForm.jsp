<%-- 
    Document   : index
    Created on : 16-sep-2017, 22:38:31
    Author     : ubaldino
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Taller I</title>
  <%@include file="head.jsp"%> 
  <style type="text/css">
  fieldset {
  	border: 1px solid #dedede;
  }

  legend {
  	font-size: 20px;
  	text-transform: uppercase;
  }

  .error {
  	color: red;
  }

  .resltTable {
  	width: 50%;
  	border-collapse: collapse;
  	border-spacing: 0px;
  }

  .resltTable td, .resltTable th {
  	border: 1px solid #565454;
  }
  </style>
</head>
<body>
  <fieldset>
    <legend>User Input From</legend>
    <form:form action="saveUser" method="post" modelAttribute="user">
      <table>
        <tr>
          <th>Login</th>
          <td>
            <form:input path="login" /> 
            <form:errors path="login" cssClass="error" />
          </td>
          <th>Password</th>
          <td>
            <form:input path="password" /> 
            <form:errors path="password" cssClass="error" />
          </td>
          <td><button type="submit">Submit</button></td>
        </tr>
      </table>
    </form:form>
  </fieldset>
  <br>
  <br>

  <fieldset>
    <legend>Users List</legend>
    <table class="resltTable">
      <tr>
        <th>Login</th>
        <th>Estado</th>
      </tr>
      <c:forEach items="${users}" var="user">
        <tr>
          <td>${user.login}</td>
          <td>${user.estado}</td>
        </tr>
      </c:forEach>

    </table>
  </fieldset>

</body>
</html>