package com.ipartek.jonBarnes.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//imports paquetes nuestros.
import com.ipartek.ejemplos.javierlete.dal.DALFactory;
import com.ipartek.ejemplos.javierlete.dal.UsuariosDAL;
import com.ipartek.ejemplos.javierlete.tipos.Usuario;

/**
 * Servlet implementation class UsuarioCRUDServlet
 */
@WebServlet("/usuariocrud")
public class UsuarioCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Llama al metodo doPost.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * 
	 * Metodo que hacemos cuando recibimos datos del jsp.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		// Recogemos los datos.

		String op = request.getParameter("op");

		// Operaciones
		if (op == null) { // Primera vez que entro.

			// Creo el elemento.
			UsuariosDAL dal = DALFactory.getUsuariosDAL();

			// Devuelve todos los usuarios.
			Usuario[] usuarios = dal.buscarTodosLosUsuarios();

			// Empaqueto en la request
			request.setAttribute("usuarios", usuarios);

			request.getRequestDispatcher("/WEB-INF/vistas/usuariocrud.jsp").forward(request, response);
		}
		// redirigomos los datos.

	}
}
