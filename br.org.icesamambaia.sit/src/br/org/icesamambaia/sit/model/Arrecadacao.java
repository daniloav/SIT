package br.org.icesamambaia.sit.model;

import java.util.Date;

public abstract class Arrecadacao {
	private Date competencia;
	private int id;
	private int idMembro;
	private double valor;
	private int idUsuario;
	private Date dataLanc;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Date competencia) {
		this.competencia = competencia;
	}

	public Date getDataLanc() {
		return dataLanc;
	}

	public void setDataLanc(Date dataLanc) {
		this.dataLanc = dataLanc;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(int idMembro) {
		this.idMembro = idMembro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
