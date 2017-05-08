package com.ipartek.jonBarnes.controladores;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.ejemplos.javierlete.dal.DALFactory;
import com.ipartek.ejemplos.javierlete.dal.UsuariosDAL;
import com.ipartek.ejemplos.javierlete.tipos.Usuario;

//imports paquetes nuestros.

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
		ServletContext applicationDAL = request.getServletContext();
		UsuariosDAL dal = (UsuariosDAL) applicationDAL.getAttribute("dal");
		// Solo creamos el DAL solo si no existe.
		if (dal == null) {
			dal = DALFactory.getUsuariosDAL();

			// Para hacer pruebas creamos tres usuarios.
			dal.alta(new Usuario("usuario1", "pass1"));
			dal.alta(new Usuario("usuario2", "pass2"));
			dal.alta(new Usuario("usuario3", "pass3"));

			applicationDAL.setAttribute("dal", dal);
		}
		String op = request.getParameter("op");

		// Operaciones
		if (op == null) { // Primera vez que entro.

			// Devuelve todos los usuarios.
			Usuario[] usuarios = dal.buscarTodosLosUsuarios();

			// Empaqueto en la request
			request.setAttribute("usuarios", usuarios);

			request.getRequestDispatcher("/WEB-INF/vistas/usuariocrud.jsp").forward(request, response);
		}
		// redirigomos los datos.

	}
}
