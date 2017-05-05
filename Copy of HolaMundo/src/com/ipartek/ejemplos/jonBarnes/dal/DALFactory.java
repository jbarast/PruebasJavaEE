package com.ipartek.ejemplos.jonBarnes.dal;

import com.ipartek.ejemplos.javierlete.dal.UsuariosDAL;
import com.ipartek.ejemplos.javierlete.tipos.Usuario;

/**
 * 
 * Clase para tener las constantes.
 * 
 * @author jbarast
 * @version 05/05/2017
 *
 */
public class DALFactory {

	

		

	public static UsuariosDAL getUsuariosDAL() {
		return new UsuariosDALCol();
	}

}
