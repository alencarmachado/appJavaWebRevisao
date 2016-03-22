package br.com.csi.modelo;

public class Usuario {

	
	/*
	 
create table usuario(codigo serial, login varchar(30) not null, senha varchar(30) not null, primary key(codigo))

insert into usuario(login, senha) values ('mariana','123')	  
	  
	 
	 * */
	
	private int codigo;
	private String login;
	private String senha;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
