//UsuariosDALCol.java

package com.ipartek.ejemplos.jonBarnes.dal;

//imports java
import java.util.HashMap;
import java.util.Map;

//import paketes.
import com.ipartek.ejemplos.javierlete.dal.UsuariosDAL;
import com.ipartek.ejemplos.javierlete.tipos.Usuario;

/**
 * 
 * Clase para el "manejo" de usuarios.
 * 
 * @author jbarast
 * @version 05/05/2017
 * @since 05/05/2017
 * 
 */
public class UsuariosDALCol implements UsuariosDAL {

	@Override
	public void modificar(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario buscarPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario[] buscarTodosLosUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	// Atributos.
	private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();

	/**
	 * 
	 * Metodo para el alta de usuarios.
	 * 
	 */
	@Override
	public void alta(Usuario usuario) {

		// Metemos el usuario en la coleccion usuarios.
		usuarios.put(usuario.getNombre(), usuario);

	}

	/**
	 * 
	 * Metodo para validar un usuario para el login.
	 * 
	 * @return esValida Devuelve true si es valido o false si no es valido.
	 */
	@Override
	public boolean validar(Usuario usuario) {

		// Atributo que devolvemos.
		boolean esValida = false;

		// Operacion.
		esValida = usuarios.containsValue(usuario);

		// Return.
		return esValida;
	}

}
