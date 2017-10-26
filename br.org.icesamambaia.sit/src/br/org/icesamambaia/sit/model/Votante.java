package br.org.icesamambaia.sit.model;

import java.util.Date;

public class Votante extends Membros {
	private static int cod = 20170;
	private Cargo cargo;
	private String cpf;
	

	@Override
	public String toString() {
		return "\n\nVotante criado:\nMatricula: "+Votante.cod+"\nNome: " + this.getNome() + "\nSobrenome: " + this.getSobreNome() +"\nCargo: "+this.getCargo()+"\nCPF: "+this.getCpf()+"\nData de Nascimento: "
				+ this.getDataNascimento() + "\nData de ingresso: " + this.getDataIngresso() + "\nEmail: "
				+ this.getEmail() + "\nTelefone: " + this.getTelefone() + "\nCelular: "+this.getCelular()+"\nLogin: "+this.getLogin();
	}

	public Votante(int id,String nome, String sobreNome, Date dataNascimento, Date dataIngresso, String email, String telefone,
			String celular, String login, String senha, Cargo cargo, String cpf) {
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
		this.setCargo(cargo);
		this.setCpf(cpf);
		Votante.incrementa();
	}
	
	public static void incrementa() {
		Votante.cod++;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
