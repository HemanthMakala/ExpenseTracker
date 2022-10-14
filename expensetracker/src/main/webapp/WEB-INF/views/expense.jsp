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
<h2>Add Expense</h2>
<form:form action="${contextRoot}/expense" method="post" modelAttribute="expense">

<form:input path="expensename" placeholder="Enter Expense Name"/><br />
<form:input path="amount" placeholder="Enter Amount"/><br />
<form:input path="note" placeholder="Enter Note"/>
<button type="submit">Add Expense</button>

</form:form>
</div>

</body>
</html>