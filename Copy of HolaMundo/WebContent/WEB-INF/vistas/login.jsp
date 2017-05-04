<%@include file="includes/cabecera.jsp" %>

	<jsp:useBean id="usuario" scope="request"
		class="com.ipartek.ejemplos.javierlete.tipos.Usuario" />

	<form action="login" method="post">
		<fieldset>
			<label for="nombre">Nombre</label> <input id="nombre" name="nombre" requiered="required" minlength="4"
				value="${usuario.nombre}" />
		</fieldset>
		<fieldset>
			<label for="pass">Contraseña</label> <input type="password" id="pass"
				name="pass" />
		</fieldset>
		<fieldset>
			<input type="submit" value="Login" />
			<p class="errores">${usuario.errores}</p>
		</fieldset>
	</form>
	
	<%--Para redirigir el alta al login. --%>
	<form action="alta" method="post">
	   <fieldset>
	      <input type="submit" value="Alta"/>
	   </fieldset>
	</form>

	<%@include file="includes/pie.jsp" %>