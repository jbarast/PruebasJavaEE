//UsuariosDALColeecion.java

package com.ipartek.ejemplos.javierlete.dal;

import java.util.HashMap;
import java.util.Map;

import com.ipartek.ejemplos.javierlete.tipos.Usuario;

/**
 * 
 * Clase para tener los usuarios.
 * 
 * @author jbarast
 * @version 08/05/2017
 *
 */
public class UsuariosDALColeccion implements UsuariosDAL {

	private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();

	@Override
	public void alta(Usuario usuario) {

		if (usuarios.containsKey(usuario.getNombre()))
			throw new UsuarioYaExistenteDALException("Ya existe el usuario " + usuario.getNombre());
		usuarios.put(usuario.getNombre(), usuario);
	}

	@Override
	public boolean validar(Usuario usuario) {
		return usuarios.containsValue(usuario);
	}

	/**
	 * Funcion para modificar un usuario. Primero tenemos que buscar un usuario.
	 */
	@Override
	public void modificar(Usuario usuario) {
		// Cuando meto un elemento con el mismo metodo. Sobreescribe el
		// anterior.
		if (!usuarios.containsKey(usuario.getNombre())) { // Comprobamos que
															// primero existe el
															// usuario. Si no es
															// error grave.
			throw new DALException("Intento de modificar usuario no existente " + usuario);
		} else {
			usuarios.put(usuario.getNombre(), usuario);
		}
	}

	/**
	 * Metodo para borrar un usuario de la memoria.
	 */
	@Override
	public void borrar(Usuario usuario) {
		usuarios.remove(usuario.getNombre());

	}

	/**
	 * Metodo para buscar un usuario por su id.
	 */
	@Override
	public Usuario buscarPorId(String id) {
		// La id es la Key del HashMap.
		return usuarios.get(id);
	}

	/**
	 * Metodo que devuelve todos los usuarios que hay dentro en un Array.
	 */
	@Override
	public Usuario[] buscarTodosLosUsuarios() {
		// Lo hacemos con un for.

		// Creamos el array que saldra.
		Usuario[] arrUsuarios = new Usuario[usuarios.size()];

		// Hacemos un for.
		int i = 0;
		for (Usuario usuario : usuarios.values()) {
			arrUsuarios[i++] = usuario;
		}

		// El return.
		return arrUsuarios;

		// Otro metodo.
		// return usuarios.values().toArray(new Usuario[usuarios.size()]);

		// El new Usuario[0], es un truco para que me genere siempre un Array
		// con los datos.
		// Estructura rara de Java.
		// return usuarios.entrySet().toArray(new Usuario[0]);
		// return (Usuario[]) usuarios.entrySet().toArray(); // Asi no funciona.
	}

}
