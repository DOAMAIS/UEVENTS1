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

public class AtividadeDao {
	private Connection connection;
	
	public AtividadeDao(){
		
		try{
			this.connection = new ConnectionFactory().getConnection();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void cadastrar(Atividade atividade){
		
		PreparedStatement stmt;
		String sql = "INSERT INTO atividade (nome_atividade, descricao_atividade, orientador, observacao, data_atividade, hora_inicio, hora_termino,limite, id_evento, local, id_orientador) values (?,?,?,?,?,?,?,?,?,?,?)";
		
		try{
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, atividade.getNome());
			stmt.setString(2, atividade.getDescricao());
			stmt.setString(3, atividade.getOrientador());
			stmt.setString(4, atividade.getObservacao());
			stmt.setDate(5, new java.sql.Date(atividade.getData().getTime()));
			stmt.setString(6, atividade.getHoraInicio());
			stmt.setString(7, atividade.getHoraTermino());
			stmt.setInt(8, atividade.getLimite());
			stmt.setInt(9, atividade.getId_evento());
			stmt.setString(10, atividade.getLocal());
			stmt.setInt(11, atividade.getId_orientador());
			
			stmt.execute();
			connection.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Atividade atividade){
		
		PreparedStatement stmt;
		String sql = "UPDATE atividade SET nome_atividade = ?, descricao_atividade= ?, orientador = ?, observacao = ?, data_atividade = ?, hora_inicio = ?, hora_termino = ?,limite = ?, local =?, id_evento=?  where id=?";
		
		try{
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, atividade.getNome());
			stmt.setString(2, atividade.getDescricao());
			stmt.setString(3, atividade.getOrientador());
			stmt.setString(4, atividade.getObservacao());
			stmt.setDate(5, new java.sql.Date(atividade.getData().getTime()));
			stmt.setString(6, atividade.getHoraInicio());
			stmt.setString(7, atividade.getHoraTermino());
			stmt.setInt(8, atividade.getLimite());
			stmt.setString(9, atividade.getLocal());
			stmt.setInt(10, atividade.getId_evento());
			stmt.setInt(11, atividade.getId());
			
			stmt.execute();
			connection.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Atividade buscarPorId(Atividade atvd){
		ResultSet rs;
		PreparedStatement stmt;
		String sql = "SELECT * FROM atividade WHERE id=?";
		Atividade atv = new Atividade();
		
		try{
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, atvd.getId());
			rs = stmt.executeQuery();
			
			while(rs.next()){
			
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
				
			}
			
			rs.close();
			connection.close();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return atv;
	}
	
	public List<Atividade> listar(){
		
		List<Atividade> listaAtividades = new ArrayList<>();
		ResultSet rs;
		PreparedStatement stmt;
		String sql = "SELECT * FROM atividade";
		
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
				atv.setLocal(rs.getString("local"));
				atv.setLimite(rs.getInt("limite"));
				atv.setId_evento(rs.getInt("id_evento"));
				atv.setId_orientador(rs.getInt("id_orientador"));
				
				
				
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
	
	public List<Atividade> listarAtividadeUsuario(Usuario usuario){
			//select usuario_has_atividade.id_atividade, atividade.nome_atividade, usuario_has_atividade.id_usuario, usuario.nome from usuario_has_atividade, usuario, atividade WHERE usuario_has_atividade.id_atividade = atividade.id and usuario_has_atividade.id_usuario=usuario.id and usuario.id=6;
			List<Atividade> listaAtividades = new ArrayList<>();
			ResultSet rs;
			PreparedStatement stmt;
			String sql = "SELECT * FROM atividade";
			
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
					atv.setLocal(rs.getString("local"));
					atv.setLimite(rs.getInt("limite"));
					atv.setId_evento(rs.getInt("id_evento"));
					atv.setMatriculado(retornaUsuariomatriculado(rs.getInt("id"),usuario));
					atv.setId_orientador(rs.getInt("id_orientador"));
					
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
	
		public int retornaUsuariomatriculado(int idatividade,Usuario usuario) {
			
			ResultSet rs;
			PreparedStatement stmt;
			String sql = "SELECT * FROM usuario_has_atividade where id_atividade=? and id_usuario=?";
			
			try{
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1,idatividade);
				stmt.setInt(2,usuario.getId() );
				rs = stmt.executeQuery();
				while(rs.next()){
					return 1;
				}
				
				
				
				rs.close();
				stmt.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
			
			
			return 0;
			
		}
		
		public List<Usuario> listarUsuariosParticipantes(Atividade atv) {
			
			ResultSet rs;
			PreparedStatement stmt;
			String sql = "SELECT usuario_has_atividade.id_usuario, usuario.nome FROM usuario_has_atividade, usuario, atividade WHERE usuario_has_atividade.id_usuario = usuario.id and usuario_has_atividade.id_atividade=atividade.id and atividade.id=?;";
			List<Usuario> listaUsuarios = new ArrayList<>();
			
			try{
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, atv.getId());

				rs = stmt.executeQuery();
				while(rs.next()){
					Usuario user = new Usuario();
					
					user.setId(rs.getInt("id_usuario"));
					user.setNome(rs.getString("nome"));
					
					listaUsuarios.add(user);
				}
				
				rs.close();
				stmt.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
			return listaUsuarios;
			
		}
				
		public void remover(Atividade atividade){
			
			PreparedStatement stmt;
			String sql = "DELETE FROM atividade WHERE id=?";
			
			try{
				stmt = connection.prepareStatement(sql);
				
				stmt.setInt(1, atividade.getId());
		
				
				stmt.execute();
				connection.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
		
}
