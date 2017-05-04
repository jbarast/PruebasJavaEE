<%--
  Document : chat.jsp
  Jsp del chat
  Version  : 04/05/2017
  Author   : jbarast
 --%>
 
 <%--Cabezera de la pagina --%>
<%@include file="includes/cabecera.jsp" %>

<%--Rellenamos el texto a añadir al chat. --%>

<form>
<fieldset>
			<label for="texto">Respuesta: </label> <input  id="texto"
				name="texto" />
		</fieldset>
		<fieldset>
			<input type="submit" value="Responder" />			
		</fieldset>



</form>


<%--Visualizamos el texto. --%>




<%--Pie de la pagina. --%>
<%@include file="includes/pie.jsp" %>