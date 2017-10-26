package br.org.icesamambaia.sit.model;

import java.util.Date;

public class Dizimo extends Arrecadacao {
	private Votante nome;
	

	public Dizimo(double valor, Votante nome, Date competencia, Date dataLanc) {
		this.setNome(nome);
		this.setValor(valor);
		this.setCompetencia(competencia);
		this.setDataLanc(dataLanc);

	}

	@Override
	public String toString() {

		return "\n\nValor: " + this.getValor() + "\nCompetencia: " + this.getCompetencia() + "\nData: " + this.getDataLanc()
				+ "\nNome: " + this.getNome().getNome();
	}

	
	public Votante getNome() {
		return nome;
	}

	public void setNome(Votante nome) {
		this.nome = nome;
	}

}
