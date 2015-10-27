<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
</head>
<body>
<h1>Employee List</h1>
<table>
	<tr>
		<td><a href="${pageContext.request.contextPath}/addemployee">Add Employee</a>
	</tr>
	<tr>
		<th>Nomor</th>
		<th>Nama</th>
		<th>Pekerjaan</th>
		<th>Unit</th>
		<th>Gaji</th>
		<th>Action</th>
	</tr>
	<c:forEach var="employee" items="${employeeList}" varStatus="status">
	<tr>
		<td>${status.index + 1}</td>
		<td>${employee.nama}</td>
		<td>${employee.pekerjaan}</td>
		<td>${employee.unit}</td>
		<td>${employee.gaji}</td>
		<td>
			<a href="${pageContext.request.contextPath}/employee/edit/${employee.employeeID}">Edit</a>
			<a href="${pageContext.request.contextPath}/employee/delete/${employee.employeeID}"
			onclick="return confirm('Yakin untuk delete?');">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>