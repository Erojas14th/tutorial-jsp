<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<div class="container">
	<a href="persona?direccion=goSave">Nuevo</a>

	
		<table border="2">
			<thead>
				<th>#</th>
				<th>Nombre</th>
			</thead>
			<tbody>

				<c:forEach items="${lista}" var="e">
					<tr>
						<td><c:out value="${e.id}" /></td>
						<td><c:out value="${e.nombre}" /></td>
						<td><a href="persona?direccion=getOne&id=<c:out value="${e.id}" />">Modificar</a></td>
						<td><a href="persona?direccion=deleteById&id=<c:out value="${e.id}" />">Eliminar</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>