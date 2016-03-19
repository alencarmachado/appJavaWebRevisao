package br.com.csi.dao;
import br.com.csi.modelo.*;
import br.com.csi.util.ConnectionFactoryPostGress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author Alencar
 *
 */
public class UsuarioDao {
	
	/**
	    create table usuario(codigo serial, login varchar(40) not null, 
		senha varchar(40) not null, primary key(codigo))
		
		insert into usuario (login, senha) values ('mariana','123')
	 */
	
	public static void main(String args[]){
		UsuarioDao ud = new UsuarioDao();
		
		Usuario u = new Usuario();
		u.setLogin("mariana");
		u.setSenha("123");
		//exemplo sqlInjector
		//u.setSenha("'or'1'='1");
		
		//''or'1'='1'
		 
		try {
		System.out.println(new UsuarioDao().logado(u));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean logado(Usuario u) throws Exception{
		Connection con = new ConnectionFactoryPostGress().conexao();
		Statement stmt = con.createStatement();
		
		boolean retorno = false;
		
		//exemplo sqlInjector
		//ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIO where login ='"+u.getLogin()+"' and senha ='"+u.getSenha()+"'");
		
		
		String sql = "SELECT * FROM USUARIO where login =? and senha = ?";				
		PreparedStatement stmtPre = null;
		stmtPre = con.prepareStatement(sql);		
		stmtPre.setString(1, u.getLogin());
		stmtPre.setString(2, u.getSenha());
		
		ResultSet rs = stmtPre.executeQuery();
		
		
		while (rs.next()) {
			int id = rs.getInt("codigo");
			String name = rs.getString("login");
			String prioridade = rs.getString("senha");
			
			retorno = true;
			System.out.println("ID = " + id);
			System.out.println("NAME = " + name);
			System.out.println("prioridade = " + prioridade);			
		
		}
		
		rs.close();
		stmt.close();
		con.close();
		
		return retorno;
	}
	
}
