<%--usuarioscrud.jsp --%>
<%--

Jsp para hacer el crud.

Autor: jbarast
Version: 08/05/2017

 --%>


<%--Cabezara del Jsp. --%>
<%@ include file="includes/cabecera.jsp" %>



<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Mantenimiento de usuarios</h2>

<table border="1">
	<thead>
		<tr>
			<th>Operaciones</th>
			<th>Usuario</th>
			<th>Contraseña</th>
		</tr>
	</thead>
	<tbody>
	
		<tr>
			<td><a href="?op=modificar">Modificar</a><a href="?op=borrar">Borrar</a></td>
			<td>Usuario1</td>
			<td>Contraseña1</td>
		</tr>
		
	</tbody>
</table>

<a href="?op=alta">Alta</a>


<%--Pie del Jsp. --%>
<%@ include file="includes/pie.jsp" %>