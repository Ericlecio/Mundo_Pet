package br.edu.ifpe.mundopet.model;

import java.util.Date;

public class Endereco extends Usuario{
	private int idenderenco;
	private String bairro;
	private String rua;
	private String cidade;
	private int numero;
	private String uf;
	private int idusuario;
	private Usuario usuario;


	public Endereco(int idenderenco, String bairro, String rua, String cidade, int numero, String uf, Usuario usuario) {
		super();
		this.idenderenco = idenderenco;
		this.bairro = bairro;
		this.rua = rua;
		this.cidade = cidade;
		this.numero = numero;
		this.uf = uf;
		this.usuario = usuario;
	}
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getIdenderenco() {
		return idenderenco;
	}
	
	public void setIdenderenco(int idenderenco) {
		this.idenderenco = idenderenco;
	}
	
	public int getIdusuario() {
		return usuario.getIdusuario();

	}
	
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
	public int getUsuario() {
		return usuario.getIdusuario();
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getIdEndereco() {
		return idenderenco;
	}

	public void setIdEndereco(int idEnderenco) {
		this.idenderenco = idEnderenco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
