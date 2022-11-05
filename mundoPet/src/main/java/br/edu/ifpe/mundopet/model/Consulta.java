package br.edu.ifpe.mundopet.model;

import java.util.Date;

public class Consulta {
	private int idconsulta;
	private String nome;
	private Date data_Consulta;
	private int horario;

	private Usuario usuario;
	private Veterinario veterinario;
	private Consulta consulta;


	public Consulta(int idconsulta, String nome, Date data_Consulta, int horario, Usuario usuario,
			Veterinario veterinario, Consulta consulta ) {
		super();
		this.idconsulta = idconsulta;
		this.nome = nome;
		this.data_Consulta = data_Consulta;
		this.horario = horario;
		this.usuario = usuario;
		this.veterinario = veterinario;
		this.consulta = consulta;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
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

	public Consulta() {
		// TODO Auto-generated constructor stub
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

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

}
