package br.edu.ifpe.mundopet.model;

public class Consulta {
	private int idconsulta;
	private int idUsuario;
	private int idVeterimario;
	private String nome;
	private int data_Consulta;
	private int horario;
	
	public Consulta(int idconsulta, int idUsuario, int idVeterimario, String nome, int data_Consulta, int horario) {
		super();
		this.idconsulta = idconsulta;
		this.idUsuario = idUsuario;
		this.idVeterimario = idVeterimario;	
		this.nome = nome;
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
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdVeterimario() {
		return idVeterimario;
	}
	public void setIdVeterimario(int idVeterimario) {
		this.idVeterimario = idVeterimario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getData_Consulta() {
		return data_Consulta;
	}
	public void setData_Consulta(int data_Consulta) {
		this.data_Consulta = data_Consulta;
	}
	public int getHorario() {
		return horario;
	}
	public void setHorario(int horario) {
		this.horario = horario;
	}
	
	
	
	

}
