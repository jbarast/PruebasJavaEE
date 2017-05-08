<%--usuarioform.jsp --%>

<%--

Autor: jbarast
Version: 08/05/2017

 --%>

<%--Cabecera --%>
<%@ include file="includes/cabecera.jsp" %>




	<h2>Formulario de usuarios.</h2>
	
	<%--Imports de librerias jstl. --%>
	<%@taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%--Imports de objetos java. --%>
	<jsp:useBean id="usuario" scope="request"
		class="com.ipartek.ejemplos.javierlete.tipos.Usuario" />
		
		

	<form action="usuarioform" method="post">
		<fieldset>
			<label for="nombre">Nombre</label>
			<input id="nombre" name="nombre"
			  required="required" minlength="4"  value="${usuario.nombre}" 
			  <c:if rest="${param.op} == 'modificar'"}>  
			         readonly="readonly"
			  </c:if>
			  />
		</fieldset>
		<fieldset>
			<label for="pass">Contraseña</label> <input type="password" id="pass"
				name="pass" />
		</fieldset>
		<fieldset>
			<label for="pass2">Contraseña otra vez</label> <input type="password" id="pass2"
				name="pass2" />
		</fieldset>
		<fieldset>
			<input type="submit" value="${fn:toUpperCase(param.op)}" />
			<p class="errores">${usuario.errores}</p>
			<input type="hidden" name="op" value="${param.op }" />
		</fieldset>
	</form>
	
<%@ include file="includes/pie.jsp" %>