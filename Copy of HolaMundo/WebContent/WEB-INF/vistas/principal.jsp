<%--principal.jsp --%>

<%--Jsp, sencillo que solo entramos cuando nos hemos logueado de fomra valida.. --%>
<%--author: jbarast --%>
<%--version: 04/05/2017 --%>


<%@include file="includes/cabecera.jsp" %>

	<h1>Principal</h1>
	
	<%--Nos dice el nombre del usuario. --%>
	<jsp:useBean id="usuario" scope="session" 
		class="com.ipartek.ejemplos.javierlete.tipos.Usuario" />
		
	<%--Funcion de logout. --%>		
	<h2>Bienvenido ${usuario.nombre} <a href="login?opcion=logout">Logout</a></h2>
	
	<%--Nos muestra la fecha actual. --%>
	<h3><%= new java.util.Date() %></h3>

	
<%@include file="includes/pie.jsp" %>