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
<form:form action="${contextRoot}/updateuserdetails/${user.id}" method="post" modelAttribute="user">
<div class="user-box" ><form:input style="border: 1px solid #fff;" path="fullName" placeholder="Enter Full Name" required="true"/></div>
<div class="user-box"><form:input style="border: 1px solid #fff;" path="mailId" placeholder="Enter MailId" required="true"/></div>
<div class="user-box"><form:input style="border: 1px solid #fff;" path="password" placeholder="Enter Password" required="true"/></div>
<div class="user-box"><form:input style="border: 1px solid #fff;" path="mobileNumber" placeholder="Enter Mobile Number" required="true"/></div>
<div class="user-box"><form:input style="border: 1px solid #fff;" path="monthlyBudget" placeholder="Enter Monthly Budget" required="true"/></div>
<button type="submit">Update</button>
</form:form>
</div>

</body>
</html>