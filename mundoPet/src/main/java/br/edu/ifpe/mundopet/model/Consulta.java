package br.edu.ifpe.mundopet.model;

import java.util.Date;

public class Consulta {
	private int idconsulta;
	private String nome;
	private Date data_Consulta;
	private String horario;

	private Usuario usuario;
	private Veterinario veterinario;
	private Animal animal;

	public Consulta(int idconsulta, String nome, Date data_Consulta, String horario) {
		super();
		this.idconsulta = idconsulta;
		this.nome = nome;
		this.data_Consulta = data_Consulta;
		this.horario = horario;
		
	}
	public int getIdconsulta() {
		return idconsulta;
	}
	public void setIdconsulta(int idconsulta) {
		this.idconsulta = idconsulta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData_Consulta() {
		return data_Consulta;
	}
	public void setData_Consulta(Date data_Consulta) {
		this.data_Consulta = data_Consulta;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Veterinario getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}
}
