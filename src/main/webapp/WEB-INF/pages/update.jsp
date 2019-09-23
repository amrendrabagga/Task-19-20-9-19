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
<h2 align="center">Update Employee</h2>
<hr>
<spring:htmlEscape defaultHtmlEscape="true" /> 
<form:form action="UpdateEmp" method="post" modelAttribute="emp">
<table align="center" cellspacing="0" cellpadding="9px">
<tr>
<td>Eno</td>
<td><form:hidden path="eno"/>${emp.eno}</td>
</tr>

 <tr>
<td>Ename</td>
<td><form:input path="ename"/></td><td><form:errors path="ename" cssClass="error"/></td>
</tr>
<tr>
<td>Salary</td>
<td><form:input path="salary"/></td>
<td>
<form:errors path="salary" cssClass="error"/></td><!-- explicitly setting msg(Invalid number) for number format exception  -->
</tr>

<tr>
<td>Designation</td>
<td><form:input path="designation"/></td><td><form:errors path="designation" cssClass="error"/></td>
</tr>

<tr>
<td>Department</td>
<td><form:select path="dept" items="${depts}"/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="SUBMIT">
</tr>
</table>
</form:form>
<a href="index.jsp">Home</a>
</body>
</html>