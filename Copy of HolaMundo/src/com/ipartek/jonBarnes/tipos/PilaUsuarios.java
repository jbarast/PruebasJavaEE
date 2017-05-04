//PilaUsuarios.java

package com.ipartek.jonBarnes.tipos;

//imports.
import java.util.Stack;

/**
 * 
 * Clase para la gestion de una pila de usuarios.
 * 
 * @author jbarast
 * @version 04/05/2017
 *
 */
public class PilaUsuarios {

	// Creamos la pila.
	Stack<String> pilaChat = new Stack<String>();

	// Necesitamos un constructor vacio.
	public PilaUsuarios(Stack<String> pilaChat) {
		super();
		this.pilaChat = pilaChat;
	}

	public PilaUsuarios() {
		super();
		this.pilaChat.add("elemento0");

	}

	// Getters y setters.
	public Stack<String> getPilaChat() {
		return pilaChat;
	}

	public void setPilaChat(String texto) {
		this.pilaChat.add(texto);
	}

	// Otros metodos.
	@Override
	public String toString() {
		return "PilaUsuarios [pilaChat=" + pilaChat + "]";
	}

}
