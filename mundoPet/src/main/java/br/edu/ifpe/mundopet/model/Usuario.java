package br.edu.ifpe.mundopet.model;

public class Usuario {
	private int idusuario;
	private String nome;
	private int data_Nasc;
	private String email;
	private int cpf;
	private String senha;

	public Usuario(int idusuario, String nome, int data_Nasc, String email, int cpf, String senha) {
		super();
		this.idusuario = idusuario;
		this.nome = nome;
		this.data_Nasc = data_Nasc;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
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
