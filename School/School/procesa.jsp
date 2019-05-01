<!DOCTYPE HTML>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>School</title>
</head>
<body>

<table border="1">
	<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Student ID</th>
			<th>Program</th>
	</tr>
  <c:forEach items="${requestScope.alumnos}" var="al">
	  <tr>
			<td>
        <c:out value="${al.nombre}" />
      	<br />
			</td>
			<td>
        <c:out value="${al.edad}" />
      	<br />
			</td>
			<td>
        <c:out value="${al.matricula}" />
      	<br />
			</td>
			<td>
        <c:out value="${al.carrera}" />
      	<br />
			</td>
		</tr>
  </c:forEach>
</table>
<br />
<a href="./index.html">Back</a>
</body>
</html>
