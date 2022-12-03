package br.edu.ifpe.mundopet.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Consulta {
	private int idconsulta;
	private String nomeUsuario;
	private String nomeVeterinario;
	private String nomeAnimal;
	private String tipo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data_Consulta;
	private String horario;
	
	public Consulta(int idconsulta, String nomeUsuario, String nomeVeterinario, String nomeAnimal, String tipo,
			Date data_Consulta, String horario) {
		super();
		this.idconsulta = idconsulta;
		this.nomeUsuario = nomeUsuario;
		this.nomeVeterinario = nomeVeterinario;
		this.nomeAnimal = nomeAnimal;
		this.tipo = tipo;
		this.data_Consulta = data_Consulta;
		this.horario = horario;
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
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getNomeVeterinario() {
		return nomeVeterinario;
	}
	public void setNomeVeterinario(String nomeVeterinario) {
		this.nomeVeterinario = nomeVeterinario;
	}
	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	
	

	
	
	
}
