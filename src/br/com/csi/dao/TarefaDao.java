package br.com.csi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.csi.modelo.Tarefa;
import br.com.csi.util.ConnectionFactoryPostGress;

public class TarefaDao {

	public void adiciona(Tarefa t){
		
		Connection c = null;
		PreparedStatement stmt = null;
		try {

			c = ConnectionFactoryPostGress.conexao();
			String sql = "INSERT INTO TAREFA (DESCRICAO, FINALIZADO, DATAFINALIZACAO) "
					+ " values (?,?,?)";
			
			stmt = c.prepareStatement(sql);
			
			stmt.setString(1, t.getDescricao());
			stmt.setBoolean(2, t.isFinalizado());
			stmt.setDate(3, new java.sql.Date(t.getDataFinalizacao().getTimeInMillis()));
			stmt.execute();			
			stmt.close();
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			
		}					
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
