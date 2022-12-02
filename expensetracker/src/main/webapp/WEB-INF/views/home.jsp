<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>  
 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<style><%@include file="/WEB-INF/css/home.css" %></style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
function deleteprompt(){
	alert("Do You realy want to delete the expense");
}
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

<form:form action="${contextRoot}/userdetails" method="get">
    <button class="usericn" type="submit">${fn:substring(user.fullName, 0, 1)}</button>
</form:form>

<br>
<div class="totalExp"><h1>Total Expense: &#8377; ${totalExpense}</h1></div><br><br>
<c:if test="${not empty user.monthlyBudget}">
    <div class="totalExp"><h1>Your Monthly Budget id: &#8377; ${user.monthlyBudget}</h1></div><br><br>
    <div class="totalExp"><h1>You have &#8377;${user.monthlyBudget - totalExpense} in your wallet</h1></div><br>
	</c:if>
	
<c:if test="${empty user.monthlyBudget}">
    <form:form class="searchVal" action="${contextRoot}/mntlyExpUp" method="post" modelAttribute="user">
	<form:input class="searchVal" style="width:120px" path="monthlyBudget"/>
    <button class="addexp" type="submit">Set Monthly Expense</button>
  </form:form>
</c:if>


<form:form action="${contextRoot}/exportExp" method="post" modelAttribute="expenselist">
<form:input path="expenseListObj" type="hidden"/>
    <button class="btn" type="submit"><i class="fa fa-download"></i> Download</button>
  </form:form>
<br>


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
  
		<td><a href="${contextRoot}/expense/${expense.id}/delete" onclick="deleteprompt()"><img class="imgDel" src=https://cdn-icons-png.flaticon.com/128/3221/3221803.png width="90" 
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