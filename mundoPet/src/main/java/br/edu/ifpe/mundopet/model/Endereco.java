package br.edu.ifpe.mundopet.model;

public class Endereco {
	private int idEnderenco;
	private int idUsuario;
	private String bairro;
	private String rua;
	private String cidade;
	private int numero;
	private String uf;
	
	public int getIdEndereco() {
		return idEnderenco;
	}
	public void setIdEndereco(int idEnderenco) {
		this.idEnderenco = idEnderenco;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
