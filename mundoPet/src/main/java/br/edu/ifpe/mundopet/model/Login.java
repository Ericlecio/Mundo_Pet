package br.edu.ifpe.mundopet.model;

public class Login {
	private String email;
	private String senha;
	
	private Usuario usuario;

	public Login(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
