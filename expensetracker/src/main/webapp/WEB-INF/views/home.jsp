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
<style><%@include file="/WEB-INF/css/home.css" %></style>
<script>
var date = new Date(createdAt);
down.innerHTML = date.toString();
</script>
</head>
<body>
<h1>Expense Tracker</h1>
<br>
  <form   action="${contextRoot}/expenses" method="post">
  <div>
   <input class="searchVal" type="text" name="keyword" id="keyword" size="50" value="${keyword}" placeholder="Please Enter value" />
    </div>
    <input class = "submit" value="Submit" type="submit"/>
</form>
<br>
<br>
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
	    <th>Update Entry</th>
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
		
		<td><div class="amount">&#8377; ${expense.amount}</div></td>
  
  <td ><a class="update" href="${contextRoot}/update/${expense.id}" >Update</a></td>
  
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