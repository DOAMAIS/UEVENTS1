package br.com.ifpe.uevents.Model;

import java.io.UnsupportedEncodingException;
import java.util.List;

import br.com.ifpe.uevents.util.Util;

public class Usuario {
     private int id;
     private String  cpf;
     private String  email;
     private String  nome;
     private String  senha;
     private int  idTipoUsuario;
     private List<Atividade> atividades;
     
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha){
		try {
			this.senha = Util.crypto(senha);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public List<Atividade> getAtividades() {
		return atividades;
	}
	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	
	
}
