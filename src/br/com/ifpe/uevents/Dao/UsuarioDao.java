package br.com.ifpe.uevents.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.uevents.Model.Usuario;
import br.com.ifpe.uevents.Model.Atividade;
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
	
	public void cadastrar(Usuario usuario){		
		PreparedStatement stmt;
		String sql = "INSERT INTO usuario (cpf, email, nome, senha,id_tipo_usuario) values (?,?,?,?,?)";
		try{
			stmt = connection.prepareStatement(sql);			
			stmt.setString(1, usuario.getCpf());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getNome());
			stmt.setString(4, usuario.getSenha());
			stmt.setInt(5, usuario.getIdTipoUsuario());
			stmt.execute();
			connection.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Usuario buscarUsuario(Usuario usuario){
		
		try{
			Usuario usuarioConsultado = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from usuario where cpf = ? and senha = ? ");
			stmt.setString(1, usuario.getCpf());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				usuarioConsultado = montarObjeto(rs);
				}
			
			rs.close();
			connection.close();
			stmt.close();
			return usuarioConsultado;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public Usuario montarObjeto(ResultSet rs) throws SQLException {
		
		 Usuario usuario = new Usuario();
		 usuario.setId(rs.getInt("id"));
		 usuario.setNome(rs.getString("nome"));
		 usuario.setCpf(rs.getString("cpf"));
		 usuario.setEmail(rs.getString("email"));
		 usuario.setSenha(rs.getString("senha"));
		 usuario.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
		 
		 return usuario;
				 
	 }
	 
	 public void participarAtividade(Usuario usuario, Atividade atividade){
		PreparedStatement stmt;
		String sql = "INSERT INTO usuario_has_atividade (id_atividade, id_usuario) values(?,?);";
		try{
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, atividade.getId());
			stmt.setInt(2, usuario.getId());

			stmt.execute();
			connection.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	 }
	 
	 public void removerAtividade(Usuario usuario, Atividade atividade){
			PreparedStatement stmt;
			String sql = "DELETE FROM usuario_has_atividade WHERE id_atividade = ? AND id_usuario = ?;";
			try{
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, atividade.getId());
				stmt.setInt(2, usuario.getId());

				stmt.execute();
				connection.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
	}
	
	 public List<Atividade> listarAtvs(Usuario usuario){
		
		List<Atividade> listaAtividades = new ArrayList<>();
		ResultSet rs;
		PreparedStatement stmt;
		String sql = "select * from usuario_has_atividade, usuario, atividade WHERE usuario_has_atividade.id_atividade = atividade.id and usuario_has_atividade.id_usuario=usuario.id and usuario.id=?;";
		
		try{
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario.getId());
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
				atv.setLocal(rs.getString("local"));
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

	 public void alterar(Usuario usuario){		
		PreparedStatement stmt;
		String sql = "UPDATE usuario SET cpf=?, email=?, nome=?, senha=?,id_tipo_usuario=? WHERE id=?";
		try{
			stmt = connection.prepareStatement(sql);			
			stmt.setString(1, usuario.getCpf());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getNome());
			stmt.setString(4, usuario.getSenha());
			stmt.setInt(5, usuario.getIdTipoUsuario());
			stmt.setInt(6, usuario.getId());
			stmt.execute();
			connection.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	 public void remover(Usuario usuario){
		
		PreparedStatement stmt;
		String sql = "DELETE FROM usuario WHERE id=?";
		
		try{
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, usuario.getId());
	
			
			stmt.execute();
			connection.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

 }
