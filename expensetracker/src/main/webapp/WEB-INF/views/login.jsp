<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@include file="/WEB-INF/css/login.css"%></style>
</head>
<body>
<div class="login-box" >
  <h2>Login</h2>
  <form:form action="${contextRoot}/expenses" method="post" modelAttribute="user">
    <div class="user-box">
      <form:input path="mailId" placeholder="Please Enter MailId" required="true"/>
    </div>
    <div class="user-box">
      <form:input path="password" placeholder="Please Enter Password" required="true"/>
    </div>
    <button type="submit">Submit</button>
  </form:form>
  <br>
  <a type="button" style="color:white;" href="${contextRoot}/register"> New User ? Register </a>
</div>
</body>
</html>