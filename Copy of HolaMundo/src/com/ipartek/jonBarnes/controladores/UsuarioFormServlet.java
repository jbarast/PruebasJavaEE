//UsuarioFormServlet.java

package com.ipartek.jonBarnes.controladores;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.ejemplos.javierlete.dal.DALException;
import com.ipartek.ejemplos.javierlete.dal.UsuariosDAL;
import com.ipartek.ejemplos.javierlete.tipos.Usuario;

/**
 * 
 * 
 * @author jbarast
 * @version 08/05/2017
 */
@WebServlet("/usuarioform")
public class UsuarioFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Llamamos al metodo doPost()
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Llamamos al metodo doPost().
		doPost(request, response);
	}

	/**
	 * 
	 * Metodo doPost()
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		// variables.
		String op = request.getParameter("op");
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");

		// Para probar que el servlet funciona bien.
		// response.setContentType("text/plain");
		// PrintWriter out = response.getWriter();
		// out.println(op);
		// out.println(nombre);
		// out.println(pass);
		// out.println(pass2);

		// Las opereaciona que hacemos dependiendo de la funcion.
		if (op == null) {
			request.getRequestDispatcher(UsuarioCRUDServlet.RUTA_USUARIOCRUD).forward(request, response);
		} else {

			Usuario usuario = new Usuario(nombre, pass);

			ServletContext applicationDAL = request.getServletContext();
			UsuariosDAL dal = (UsuariosDAL) applicationDAL.getAttribute("dal");

			switch (op) {

			case "alta":
				if (pass.equals(pass2)) {
					dal.alta(usuario);
					request.getRequestDispatcher(UsuarioCRUDServlet.RUTA_SERVLET_LISTADO).forward(request, response);
				} else {
					usuario.setErrores("Las contraseñas no coinciden");
					request.setAttribute("usuario", usuario); // Para indicar el
																// usuario y el
																// empaquetado
																// de error.
					request.getRequestDispatcher(UsuarioCRUDServlet.RUTA_SERVLET_FORMULARIO).forward(request, response);
				}
				break;
			case "Modificar":
				if (pass.equals(pass2)) {
					try {
						dal.modificar(usuario);
						request.getRequestDispatcher(UsuarioCRUDServlet.RUTA_SERVLET_LISTADO)
								.forward(request, response);
					} catch (DALException de) {
						usuario.setErrores("Usuario no existente");
						request.setAttribute("usuario", usuario);
						request.getRequestDispatcher(UsuarioCRUDServlet.RUTA_SERVLET_FORMULARIO).forward(request,
								response);

					}

				} else {
					usuario.setErrores("Las contraseñas no coinciden");
					request.setAttribute("usuario", usuario); // Para indicar el
																// usuario y el
																// empaquetado
																// de error.
					request.getRequestDispatcher(UsuarioCRUDServlet.RUTA_FORMULARIO).forward(request, response);
				}
				break;
			case "borrar":
				dal.borrar(usuario);
				request.getRequestDispatcher(UsuarioCRUDServlet.RUTA_USUARIOCRUD).forward(request, response);
				break;

			}
		}
	}
}
