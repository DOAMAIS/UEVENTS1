package br.com.ifpe.uevents.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.uevents.Model.Atividade;
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
	
public List<Atividade> listar(Usuario usuario){
		
		List<Atividade> listaAtividades = new ArrayList<>();
		ResultSet rs;
		PreparedStatement stmt;
		String sql = "SELECT atividade.usuario_has_atividade where id_usuario = ?";
		
		try{
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Atividade atv = new Atividade();
				
				atv.setId(rs.getInt("id"));
				atv.setNome(rs.getString("nome_atividade"));
				atv.setDescricao(rs.getString("descricao_atividade"));
				atv.setData(rs.getDate("data_atividade"));
				atv.setHoraInicio(rs.getString("hora_inicio").substring(0, 5));
				atv.setHoraTermino(rs.getString("hora_termino").substring(0, 5));
				atv.setOrientador(rs.getString("orientador"));
				atv.setLimite(rs.getInt("limite"));
				atv.setId_evento(rs.getInt("id_evento"));
				
				
				listaAtividades.add(atv);
				
			}
			
			rs.close();
			connection.close();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		return listaAtividades;
	}
 }
