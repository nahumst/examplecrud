<%-- 
    Document   : login
    Created on : 25-jul-2016, 2:56:57
    Author     : nahum
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ejemplo CRUD</title>
</head>
<body>
<h1>USUARIOS</h1>
<form:form action="usuario.do" method="POST" commandName="usuario">
	<table>
		<tr>
			<td>ID</td>
			<td><form:input path="id" /></td>
		</tr>
		<tr>
			<td>Cuenta</td>
			<td><form:input path="cuenta" /></td>
		</tr>
		<tr>
			<td>Clave</td>
			<td><form:input path="clave" /></td>
		</tr>
		<tr>
			<td>Nombre</td>
			<td><form:input path="nombre" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Agregar" />
				<input type="submit" name="action" value="Editar" />
				<input type="submit" name="action" value="Eliminar" />
				<input type="submit" name="action" value="Buscar" />
			</td>
		</tr>
	</table>
</form:form>
<br>
<table border="1">
	<th>ID</th>
	<th>cuenta</th>
	<th>clave</th>
	<th>nombre</th>
	<c:forEach items="${usuarioList}" var="usuario">
		<tr>
			<td>${usuario.id}</td>
			<td>${usuario.cuenta}</td>
			<td>${usuario.clave}</td>
			<td>${usuario.nombre}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>