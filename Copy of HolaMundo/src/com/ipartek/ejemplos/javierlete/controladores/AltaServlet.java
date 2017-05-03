package com.ipartek.ejemplos.javierlete.controladores;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.ejemplos.javierlete.dal.UsuariosDAL;
import com.ipartek.ejemplos.javierlete.dal.UsuariosDALFijo;
import com.ipartek.ejemplos.javierlete.tipos.Usuario;

/**
 * 
 * Servlet creado para gestinoar la alta de usuario de la pagina web.
 * 
 * @author jbarast
 * @version 03/05/2017
 *
 */
@WebServlet("/alta")
public class AltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// variables.

	/* package */static final String RUTA_ALTA = LoginServlet.RUTA + "alta.jsp";

	/**
	 * 
	 * El metodo doGest() llama al metodo doPost();
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * 
	 * Metodo que recoge los datos del formulario, comprueba que son aptos y si
	 * lo son da de alta al usuario.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		// Recoger todos los datos.
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");

		// Iniciamos el usuario.
		Usuario usuario = new Usuario(nombre, pass);

		// Inicio de datos.
		// Datos incorrectos. sin rellenar, limite de caracteres, no coinciden
		// contraseñas.
		// Datos correctos: guardar.

		boolean hayDatos = nombre != null && pass != null && pass2 != null;
		boolean datosCorrectos = validarDato(nombre) && validarDato(pass) && validarDato(pass2);

		if (!hayDatos) {
			// request.getRequestDispatcher(RUTA_ALTA).forward(request,response);
		} else if (!datosCorrectos) {
			request.setAttribute("usuario", usuario);
			// request.getRequestDispatcher(RUTA_ALTA).forward(request,response);

		} else {
			ServletContext application = request.getServletContext();

			UsuariosDAL usuariosDAL = (UsuariosDAL) application.getAttribute("usuariosDAL");

			if (usuariosDAL == null) {
				usuariosDAL = new UsuariosDALFijo();
			}

			usuariosDAL.alta(usuario);
			application.setAttribute("usuariosDAL", usuariosDAL);
			// request.getRequestDispatcher(RUTA_ALTA).forward(request,response);
		}

		// Redicionamiento.
		request.getRequestDispatcher(RUTA_ALTA).forward(request, response);

	}

	/**
	 * 
	 * Metodo para saber si el campo que metemos es valido segun nuestros
	 * parametros.
	 * 
	 * @param campo
	 *            Campo que queremos ver que es valido.
	 * @return Devuelve true si el campo es valido o false si no es valido.
	 */
	private boolean validarDato(String campo) {
		return campo != null && campo.length() >= LoginServlet.MINIMO_CARACTERES;
	}
}
