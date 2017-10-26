package br.org.icesamambaia.sit.model;

import java.util.Date;

public class Oferta extends Arrecadacao {
	private String nome;



	public Oferta(double valor, String nome, Date competencia, Date dataLanc) {
		this.setNome(nome);
		this.setValor(valor);
		this.setCompetencia(competencia);
		this.setDataLanc(dataLanc);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
