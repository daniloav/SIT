package br.org.icesamambaia.sit.model;

import java.util.Date;

public class Congregante extends Membros {
	private static int cod = 123;

	public Congregante(int id,String nome, String sobreNome, Date dataNascimento, Date dataIngresso, String email,
			String telefone, String celular, String login, String senha) {
		this.setId(id);
		this.setNome(nome);
		this.setSobreNome(sobreNome);
		this.setDataNascimento(dataNascimento);
		this.setDataIngresso(dataIngresso);
		this.setEmail(email);
		this.setTelefone(telefone);
		this.setCelular(celular);
		this.setLogin(login);
		this.setSenha(senha);
		Congregante.cod++;
	}

	public String toString() {
		return "\n\nCongregante criado:\nMatricula: " + Congregante.cod + "\nNome: " + this.getNome() + "\nSobrenome: "
				+ this.getSobreNome() + "\nData de Nascimento: " + this.getDataNascimento() + "\nData de ingresso: "
				+ this.getDataIngresso() + "\nEmail: " + this.getEmail() + "\nTelefone: " + this.getTelefone()
				+ "\nCelular: " + this.getCelular() + "\nLogin: " + this.getLogin();
	}

	public static void incrementa() {
		Congregante.cod++;
	}

	@Override
	public boolean Autentica(String login, String senha) {
		if (this.getLogin().equals(login) || this.getSenha().equals(senha)) {
			return true;
		} else {
			return false;
		}

	}
}
