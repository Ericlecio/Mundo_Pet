package br.edu.ifpe.mundopet.model;

public class Animal {
	private int idanimal;
	private String nome;
	private String raca;
	private int idade;
	private String sexo;

	public Animal(int idanimal, String nome, String raca, int idade, String sexo) {
		super();
		this.idanimal = idanimal;
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
		this.sexo = sexo;
	}
	public int getIdanimal() {
		return idanimal;
	}
	public void setIdanimal(int idanimal) {
		this.idanimal = idanimal;
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
