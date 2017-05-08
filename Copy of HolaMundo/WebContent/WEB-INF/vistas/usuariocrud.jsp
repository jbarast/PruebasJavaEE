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

<%--Tabla a crear. --%>
<table border="1">

<%--Cabecera de la tabla. --%>
	<thead>
		<tr>
			<th>Operaciones</th>
			<th>Usuario</th>
			<th>Contraseña</th>
		</tr>
	</thead>
<%--Cuerpo de la tabla. --%>	
	<tbody>
	        <c:forEach items="${usuarios}" var="usuario">
	          <tr>
	             <td><a href="?op=modificar">Modificar</a><a href="?op=borrar">Borrar</a></td>
	             <td>${usuario.nombre}</td>  
	             <td>${usuario.pass}</td>          
	          </tr>          
	        </c:forEach>
		
		
	</tbody>
</table>

<a href="?op=alta">Alta</a>


<%--Pie del Jsp. --%>
<%@ include file="includes/pie.jsp" %>