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
<form:form action="${contextRoot}/expenseUp/${expenseUp.id}" method="post" modelAttribute="expenseUp">
<div class="user-box" ><form:input style="border: 1px solid #fff;" path="expensename" placeholder="Enter Expense Name"/></div>
<div class="user-box"><form:input style="border: 1px solid #fff;" path="amount" placeholder="Enter Amount"/></div>
<div class="user-box"><form:input style="border: 1px solid #fff;" path="note" placeholder="Enter Note"/></div>
<button type="submit">Add Expense</button>
</form:form>
</div>

</body>
</html>