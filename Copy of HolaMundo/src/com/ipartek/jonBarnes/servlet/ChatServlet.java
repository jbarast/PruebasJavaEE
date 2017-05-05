package com.ipartek.jonBarnes.servlet;

import java.io.IOException;
import java.util.Stack;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.jonBarnes.tipos.PilaUsuarios;

/**
 * Servlet para gestionar el chat.
 * 
 * @author jbarast
 * @version 04/05/2017
 */
@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Metodo doGet llama al metodo doPost.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// llamado a doPost().
		doPost(request, response);
	}

	/**
	 * 
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		// Cogemos los datos del formulario.
		String texto = request.getParameter("texto");

		// Añadimos los datos a la pila.
		// Iniciamos la pila.
		Stack<String> pilaChat = new Stack<String>();

		// ///
		// Inicio la aplicacion.
		ServletContext ChatApplication = request.getServletContext();
		// String todosTexto = (String) ChatApplication.getAttribute("texto");
		pilaChat = (Stack<String>) ChatApplication.getAttribute("texto");

		// Creamos el objeto pila.
		PilaUsuarios pilaUsuarios = new PilaUsuarios(pilaChat);

		// Para imprimir los elementos del stack

	}

}
