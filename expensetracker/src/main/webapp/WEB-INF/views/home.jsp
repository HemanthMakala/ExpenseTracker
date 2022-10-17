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
<div class="totalExp"><h1>Total Expense: ${totalExpense}</h1></div><br>
<a href="${contextRoot}/expense" class="addexp">Add Expense </a><br><br><br>
<c:choose>
  <c:when test="${not empty expenses}" >
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
		<td><c:if test="${not empty expense.createdAt}">
    <jsp:useBean id="myDate" class="java.util.Date"/>  
    	<c:set target="${myDate}" property="time" value="${expense.createdAt}"/> 
		 <fmt:formatDate value= "${myDate}" pattern="dd-MMM-yyyy" timeZone="IST"/> 
	</c:if></td>		
		<td>${expense.note}</td>
		<td style="
		top:20px;
		font-weight: bold;
display: block;
  height: 30%;
  width: 80%;
  margin-left: -10px;
  margin-right: -10px;
  background: #19A203;
  border-radius: 5px;
  padding: 5px 1px 1px 1px;">&#8377; ${expense.amount} </td>
		<td><a href="${contextRoot}/expense/${expense.id}/delete" ><img class="imgDel" src=https://cdn-icons-png.flaticon.com/128/3221/3221803.png width="90" 
     height="90"></a></td>
	</tr>      
</c:forEach> 
</table>
  </c:when>
  <c:otherwise>
    <h1 style="text-align: center;">There is no active Expense</h1>
  </c:otherwise>
</c:choose>
<br><br>
<a href="${contextRoot}/logout" class="logout">Logout</a>
</body>
</html>