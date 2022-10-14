<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@include file="/WEB-INF/css/home.css" %></style>
<script>
var date = new Date(createdAt);
down.innerHTML = date.toString();
</script>
</head>
<body>
<h1>Expense Tracker</h1>
<p style="color:#FFFFFF">${message}</p>
<a href="${contextRoot}/expense" style="color:#FFFFFF">Add Expense</a>
<br>
<br>
<table class="rwd-table">
<tr>
	    <th>Expense Name</th>
	    <th>Time Created</th>
	    <th>Note</th>
	    <th>Amount</th>
	    <th>Delete Expense</th>
	 </tr>
<c:forEach var="expense" items="${expenses}">

	<tr>
		<td>${expense.expensename}</td>
		<jsp:useBean id="myDate" class="java.util.Date"/>  
    	<c:set target="${myDate}" property="time" value="${expense.createdAt}"/> 
		<td> <fmt:formatDate value= "${myDate}" pattern="dd-MMM-yyyy" timeZone="IST"/> </td>
		<td>${expense.note}</td>
		<td>&#8377; ${expense.amount}</td>
		<td><a href="${contextRoot}/expense/${expense.id}/delete" ><img src=https://cdn-icons-png.flaticon.com/128/3221/3221803.png width="90" 
     height="90"></a></td>
	</tr>      
</c:forEach> 
</table>
<br><br>
<a href="${contextRoot}/logout"><button class="button">Logout</button></a>
</body>
</html>