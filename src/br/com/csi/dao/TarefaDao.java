package br.com.csi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.csi.modelo.Tarefa;
import br.com.csi.util.ConnectionFactoryPostGress;

public class TarefaDao {

	public void adiciona(Tarefa t){
		System.out.println("dentro do adiciona tarefa ........... id:"+t.getId());
		System.out.println("descrição tarefa....: "+t.getDescricao());
		
		
		Connection c = null;
		PreparedStatement stmt = null;
		try {

			c = ConnectionFactoryPostGress.conexao();
			String sql = "";
			
			if(t.getId() <= 0){
				System.out.println("......... vai adicionar .............");
				
				sql = "INSERT INTO TAREFA (DESCRICAO, FINALIZADO, DATAFINALIZACAO) "
						+ " values (?,?,?)";
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, t.getDescricao());
				stmt.setBoolean(2, t.isFinalizado());
				stmt.setDate(3, new java.sql.Date(t.getDataFinalizacao().getTimeInMillis()));
				
			}else{
				System.out.println("......... vai alterar .............");
				sql = "UPDATE TAREFA SET DESCRICAO =?, FINALIZADO=?, DATAFINALIZACAO =?  "
						+ " WHERE id =?";
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, t.getDescricao());
				stmt.setBoolean(2, t.isFinalizado());
				stmt.setDate(3, new java.sql.Date(t.getDataFinalizacao().getTimeInMillis()));
				stmt.setLong(4, t.getId());
			}
			
					
								
			stmt.execute();			
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}					
	}
	
	public Tarefa getTarefa(long id){
				Tarefa t = new Tarefa();
		try {
			Connection con = new ConnectionFactoryPostGress().conexao();
			Statement stmt = con.createStatement();
			
			String sql = "SELECT * FROM TAREFA where id =?";				
			PreparedStatement stmtPre = null;
			stmtPre = con.prepareStatement(sql);		
			stmtPre.setLong(1, id);
			
			ResultSet rs = stmtPre.executeQuery();
			while(rs.next()){
				long cod = rs.getLong("id");
				t.setId(id);
				String desc = rs.getString("descricao");
				t.setDescricao(desc);
				boolean finalizado = rs.getBoolean("finalizado");
				t.setFinalizado(finalizado);
				Date data = rs.getDate("dataFinalizacao");
				if(data !=null){
					Calendar dataFinalizacao = Calendar.getInstance();
					dataFinalizacao.setTime(data);
					t.setDataFinalizacao(dataFinalizacao);
				}						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	
	public List<Tarefa> getTarefas(){
		ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		try{
				
			PreparedStatement stmt = ConnectionFactoryPostGress.conexao().prepareStatement("select * from tarefa");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Tarefa t = new Tarefa();
				t.setId(rs.getLong("id"));
				t.setDescricao(rs.getString("descricao"));
				t.setFinalizado(rs.getBoolean("finalizado"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datafinalizacao"));				
				t.setDataFinalizacao(data);
				tarefas.add(t);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return tarefas;
	}
	
}
