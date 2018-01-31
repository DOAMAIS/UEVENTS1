package br.com.ifpe.uevents.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.ifpe.uevents.Model.Usuario;
import br.com.ifpe.uevents.util.ConnectionFactory;


public class UsuarioDao {
	private Connection connection;
	public UsuarioDao(){	
		try{
			this.connection = new ConnectionFactory().getConnection();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	public void login(Usuario usuario){
		PreparedStatement stmt;
		String sql = "SELECT * FROM usuario WHERE cpf = ? OR matricula = ? AND senha = ?";	
		try{
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getMatricula());
			stmt.setString(2, usuario.getCpf());
			stmt.setString(3, usuario.getSenha());			
			stmt.execute();
			connection.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
}
	
	public void cadastrarUsuario(Usuario usuario){		
		PreparedStatement stmt;
		String sql = "INSERT INTO usuario (cpf, matricula, email, nome, senha,id_tipo_usuario) values (?,?,?,?,?,?)";
		try{
			stmt = connection.prepareStatement(sql);			
			stmt.setString(1, usuario.getCpf());
			stmt.setString(2, usuario.getMatricula());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getNome());
			stmt.setString(5, usuario.getSenha());
			stmt.setInt(6, usuario.getIdTipoUsuario());
			stmt.execute();
			connection.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
 }
