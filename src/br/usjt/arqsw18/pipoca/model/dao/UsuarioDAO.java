package br.usjt.arqsw18.pipoca.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.arqsw18.pipoca.model.entity.Usuario;


public class UsuarioDAO {
	public boolean validar(Usuario usuario) throws IOException{
		String sql = "SELECT username, password FROM usuario "
				+ "WHERE username = ? and password = ?";
		
		try {
			Connection conn = ConnectionFactory.getConnection();
			try (PreparedStatement stm = conn.prepareStatement(sql);) {
				stm.setString(1, usuario.getUsername());
				stm.setString(2, usuario.getPassword());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		}
		return false;
	}
}

