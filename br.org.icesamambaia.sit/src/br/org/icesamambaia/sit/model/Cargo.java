package br.org.icesamambaia.sit.model;

public class Cargo {
	private String nomeCargo;
	private int nivel;
	private int id;
	
	public Cargo(String nomeCargo, int nivel) {
		this.setNomeCargo(nomeCargo);
		this.setNivel(nivel);
	}
	
	
	@Override
	public String toString() {
		return this.getNomeCargo()+"-Nivel: "+this.getNivel();
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
}
