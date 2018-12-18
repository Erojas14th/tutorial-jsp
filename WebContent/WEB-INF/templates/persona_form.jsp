<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORM</title>
</head>
<body>
	<div class="container">
		<form action="persona" method="post">

		
		<c:choose>
		<c:when test="${persona.id !=null}">
		 <c:set value="1" var="ayuda"/>
		 
		</c:when>
		<c:when test="${persona.id ==null}">
		
		<c:set value="0" var="ayuda"/>
		</c:when>
		</c:choose>
		
		<input type="hidden" name="ayuda" value='<c:out value="${ayuda}"></c:out>'>
		<input type="text" name="id" value='<c:out value="${persona.id}"></c:out>'>
		<input type="text" name="nombre" value='<c:out value="${persona.nombre}"></c:out>'>
		<input type="submit" value="Procesar">
		</form>
	</div>
</body>
</html>