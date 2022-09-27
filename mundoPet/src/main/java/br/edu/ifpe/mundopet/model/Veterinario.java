package br.edu.ifpe.mundopet.model;

public class Veterinario {
	private int idveterinario;
	private String nome;
	private int data_Nasc;
	private String email;
	private int cpf;
	private String senha;
	
	public Veterinario(int idveterinario, String nome, int data_Nasc, String email, int cpf, String senha) {
		super();
		this.idveterinario = idveterinario;
		this.nome = nome;
		this.data_Nasc = data_Nasc;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
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
	public int getData_Nasc() {
		return data_Nasc;
	}
	public void setData_Nasc(int data_Nasc) {
		this.data_Nasc = data_Nasc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
