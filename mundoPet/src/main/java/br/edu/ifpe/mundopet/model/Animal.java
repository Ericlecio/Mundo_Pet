package br.edu.ifpe.mundopet.model;

public class Animal {
	private int idAnimal;
	private String nome;
	private String raca;
	private int idade;
	private String sexo;
	
	private Usuario usuario;
	
	public Animal(int idAnimal, String nome, String raca, int idade, String sexo) {
		super();
		this.idAnimal = idAnimal;
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
		this.sexo = sexo;
	}
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
