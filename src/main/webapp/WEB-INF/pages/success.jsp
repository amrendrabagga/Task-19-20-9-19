<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Employee Details</h2><hr>
 <pre>
				Eno			:<c:out value="${emp.eno}"/>
				Ename			:<c:out value="${emp.ename}"/>
				Salary			:<c:out value="${emp.salary}"/>
				Designation		:<c:out value="${emp.designation}"/>
				Dept			:<c:out value="${emp.dept}"/>
</pre>
<hr>
<a href="dataentry">ADD Employee</a><br>
<a href="datafetch">Update/Delete Employee</a><br>
<a href="index.jsp">Home</a>
</body>
</html>