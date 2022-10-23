package br.edu.ifpe.mundopet.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {
	private int idusuario;
	private String nome;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date data_Nasc;
	private String email;
	private String cpf;
	private String senha;

	public Usuario(int idusuario, String nome, Date data_Nasc, String email, String cpf, String senha) {
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
