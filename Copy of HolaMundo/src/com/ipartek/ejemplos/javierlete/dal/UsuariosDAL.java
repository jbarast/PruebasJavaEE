//UsuariosDAL.java

package com.ipartek.ejemplos.javierlete.dal;

import com.ipartek.ejemplos.javierlete.tipos.Usuario;

/**
 * 
 * Interface de la clase usuarios DAL. Date Access Layout.
 * 
 * @author jbarast
 * @version 08/05/2017
 */
public interface UsuariosDAL {

	// Los metodos que debe tener un UsuariosDAL.
	// El crud basico. pd. C.R.U.D. = Create Retrive Update Delete.
	public void alta(Usuario usuario);

	public void modificar(Usuario usuario);

	public void borrar(Usuario usuario);

	public Usuario buscarPorId(String id);

	public Usuario[] buscarTodosLosUsuarios(); // Ponemos un array, por que es
												// un valor estandar para las
												// listas.

	public boolean validar(Usuario usuario);
}
