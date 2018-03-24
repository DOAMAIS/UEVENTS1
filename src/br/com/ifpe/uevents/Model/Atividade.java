package br.com.ifpe.uevents.Model;

import java.util.Date;

public class Atividade {
	
	private int id;
	private int id_evento;
	private String orientador;
	private int id_orientador;
	private String local;
	private String nome;
	private String descricao;
	private String observacao;
	private Date data;
	private String horaInicio;
	private String horaTermino;
	private int limite;
	private int matriculado;
	
	public int getMatriculado() {
		return matriculado;
	}
	public void setMatriculado(int matriculado) {
		this.matriculado = matriculado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_evento() {
		return id_evento;
	}
	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}
	public int getId_orientador() {
		return id_orientador;
	}
	public void setId_orientador(int id_orientador) {
		this.id_orientador = id_orientador;
	}
	public String getOrientador() {
		return orientador;
	}
	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraTermino() {
		return horaTermino;
	}
	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
		
}
