package br.com.ifpe.uevents.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.uevents.Model.Atividade;
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
		String sql = "INSERT INTO atividade (nome_atividade, descricao_atividade, orientador, observacao, data_atividade, hora_inicio, hora_termino,limite, id_evento, local) values (?,?,?,?,?,?,?,?,?,?)";
		
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
