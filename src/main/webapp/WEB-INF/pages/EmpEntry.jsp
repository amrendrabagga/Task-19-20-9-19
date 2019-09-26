<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wp.entity.Emp" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>

</head>
<body>
<h2>ENTER EMP DETAILS</h2><hr>
<spring:htmlEscape defaultHtmlEscape="true" /> 
<form:form action="SaveEmp" modelAttribute="emp">
	<table align="center"  cellspacing="0" cellpadding="6px">
		<tr>
		<td>Enter Eno</td>
		<td><form:input path="eno" /></td><td><form:errors path="eno" cssClass="error"/></td>
		
		</tr>
		<tr>
		<td>Enter Name</td><td><form:input path="ename" defaultHtmlEscape="true" /></td><td><form:errors path="ename" cssClass="error"/></td>
		</tr>
		<tr>
		<td>Enter Salary</td><td><form:input path="salary"/></td><td><form:errors path="salary" cssClass="error"/></td>
		</tr>
		<tr>
		<td>Enter Designation</td><td><form:input path="designation" defaultHtmlEscape="true"/></td><td><form:errors path="designation" cssClass="error"/></td>
		</tr>
		<tr>
		<td>Enter Department</td><td><form:input path="dept"/></td><td><form:errors path="dept" cssClass="error"/></td>
		</tr>
		<tr colspan="2" align="center">
		<td ><input type="submit" value="SUBMIT"></td>
		</tr>
	</table>
	
</form:form>
<hr>
<a href="datafetch">View All Employees</a><br>
<a href="index.jsp">Home</a>
</body>
</html>