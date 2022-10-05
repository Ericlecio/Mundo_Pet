package br.edu.ifpe.mundopet.model;

import java.util.Date;

public class Veterinario {
	private int idveterinario;
	private String nome;
	private Date data_Nasc;
	private String email;
	private String cpf;
	private String senha;
	
	public Veterinario(int idveterinario, String nome, Date data_Nasc, String email, String cpf, String senha) {
		super();
		this.idveterinario = idveterinario;
		this.nome = nome;
		this.data_Nasc = data_Nasc;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
	}
	public Veterinario() {
		// TODO Auto-generated constructor stub
	}
	public int getIdveterinario() {
		return idveterinario;
	}
	public void setIdveterinario(int idveterinario) {
		this.idveterinario = idveterinario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData_Nasc() {
		return data_Nasc;
	}
	public void setData_Nasc(Date data_Nasc) {
		this.data_Nasc = data_Nasc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
