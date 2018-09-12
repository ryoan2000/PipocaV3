package br.usjt.arqsw18.pipoca.model.service;

import br.usjt.arqsw18.pipoca.model.dao.UsuarioDAO;
import br.usjt.arqsw18.pipoca.model.entity.Usuario;

public class UsuarioService {
	public boolean validar(Usuario usuario){
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validar(usuario);
	}
}
