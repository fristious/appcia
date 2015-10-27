<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>${name}</h1>
<h3>${greetings}</h3>
<table>
	<tr>
		<td>Click Here</td>
		<td><a href="employee">List of Employees</a></td>
	</tr>
</table>
</body>
</html>
