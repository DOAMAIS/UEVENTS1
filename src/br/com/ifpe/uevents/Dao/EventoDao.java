package br.com.ifpe.uevents.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.ifpe.uevents.Model.Evento;
import br.com.ifpe.uevents.util.ConnectionFactory;


public class EventoDao {
	private Connection connection;
		
		public EventoDao(){
			
			try{
				this.connection = new ConnectionFactory().getConnection();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
		
		public void cadastrar(Evento evento){
			PreparedStatement stmt;
			String sql = "INSERT INTO evento (nome_evento, descricao_evento, data_inicio, data_termino, status, foto_evento) values (?,?,?,?,?,?)";
			try{
				stmt = connection.prepareStatement(sql);
				
				stmt.setString(1, evento.getNome());
				stmt.setString(2, evento.getDescricao());
				stmt.setDate(3, new java.sql.Date(evento.getDataInicio().getTime()));
				stmt.setDate(4, new java.sql.Date(evento.getDataTermino().getTime()));
				stmt.setString(5, evento.getStatus());
				stmt.setString(6, evento.getFoto());
				
				stmt.execute();
				connection.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
		
		public void alterar(Evento evento){
			PreparedStatement stmt;
			String sql = "UPDATE evento SET nome_evento=?, descricao_evento=?, data_inicio=?, data_termino=?, status=?, foto_evento=? WHERE id=?";
			try{
				stmt = connection.prepareStatement(sql);
				
				stmt.setString(1, evento.getNome());
				stmt.setString(2, evento.getDescricao());
				stmt.setDate(3, new java.sql.Date(evento.getDataInicio().getTime()));
				stmt.setDate(4, new java.sql.Date(evento.getDataTermino().getTime()));
				stmt.setString(5, evento.getStatus());
				stmt.setString(6, evento.getFoto());
				stmt.setInt(7, evento.getId());
				
				stmt.execute();
				connection.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
		public List<Evento> listar(){
			
			List<Evento> listaEventos = new ArrayList<>();
			ResultSet rs;
			PreparedStatement stmt;
			String sql = "SELECT * FROM evento";
			
			try{
				stmt = connection.prepareStatement(sql);
				rs = stmt.executeQuery();
				
				while(rs.next()){
					Evento evento = new Evento();
					
					evento.setId(rs.getInt("id"));
					evento.setNome(rs.getString("nome_evento"));
					evento.setDescricao(rs.getString("descricao_evento"));
					evento.setDataInicio(rs.getDate("data_inicio"));
					evento.setDataTermino(rs.getDate("data_termino"));
					evento.setStatus(rs.getString("status"));
					evento.setFoto(rs.getString("foto_evento"));
					
					listaEventos.add(evento);
				}
				
				rs.close();
				connection.close();
				stmt.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
			
			return listaEventos;
		}

		public Evento buscarPorId(int id) {
			 
			 	try {
				 	Evento evento = new Evento();
				 	PreparedStatement stmt = connection.prepareStatement("SELECT * FROM evento WHERE id = ?");
				 	stmt.setInt(1, id);
				 	ResultSet rs = stmt.executeQuery();
			 
				 	while (rs.next()) {
				        evento.setId(rs.getInt("id"));
					 	evento.setNome(rs.getString("nome_evento"));
					 	evento.setDescricao(rs.getString("descricao_evento"));
					 	evento.setDataInicio(rs.getDate("data_inicio"));
					 	evento.setDataTermino(rs.getDate("data_termino"));
					 	evento.setStatus(rs.getString("status"));
					 	evento.setFoto(rs.getString("foto_evento"));
				 	}
			 rs.close();
			 stmt.close();
			 connection.close();
			 
			return evento;
			 					
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
		
		public void remover(Evento evento){
			
			PreparedStatement stmt;
			String sql = "DELETE FROM evento WHERE id=?";
			
			try{
				stmt = connection.prepareStatement(sql);
				
				stmt.setInt(1, evento.getId());
		
				
				stmt.execute();
				connection.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
}
