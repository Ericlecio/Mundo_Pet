package br.edu.ifpe.mundopet.model;

public class Agenda {
private int idagenda;
private int data_Consulta;
private int horario;

public Agenda(int idagenda, int data_Consulta, int horario) {
	super();
	this.idagenda = idagenda;
	this.data_Consulta = data_Consulta;
	this.horario = horario;
}
public int getIdagenda() {
	return idagenda;
}
public void setIdagenda(int idagenda) {
	this.idagenda = idagenda;
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
