<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<h1>New Employee Page</h1>
	<table>
		<tr>
			<td>
				<c:url var="addAction" value="/employee/add"></c:url>
				<form:form method="POST" action="${addAction}" commandName="employee">
					<table>
						<c:if test="${!empty employee.nama}">
						<tr>
							<td>
								<form:label path="employeeID">
									<spring:message text="EmployeeID"/>
								</form:label>
							</td>
							<td>
								<form:input path="employeeID" readonly="true" size="8" disabled="true"/>
								<form:hidden path="employeeID"/>
							</td>						
						</tr>
						</c:if>
						<tr>
							<td>
								<form:label path="nama">Nama</form:label>
							</td>
							<td>
								<form:input path="nama"/>
							</td>
						</tr>
						<tr>
							<td>
								<form:label path="pekerjaan">Pekerjaan</form:label>
							</td>
							<td>
								<form:input path="pekerjaan"/>
							</td>							
						</tr>
						<tr>
							<td>
								<form:label path="unit">Unit</form:label>
							</td>
							<td>
								<form:input path="unit"/>
							</td>							
						</tr>
						<tr>
							<td>
								<form:label path="gaji">Gaji</form:label>
							</td>
							<td>
								<form:input path="gaji"/>
							</td>							
						</tr>
						<tr>
							<td colspan="2">
								<c:if test="${!empty employee.nama}">
									<input type="submit" value='<spring:message text="Update Employee"/>' />
								</c:if>
								<c:if test="${empty employee.nama}">
									<input type="submit" value='<spring:message text="Add Employee"/>' />
								</c:if>
							</td>
						</tr>						
					</table>
				</form:form>
			</td>
		</tr>
	</table>
</body>
</html>