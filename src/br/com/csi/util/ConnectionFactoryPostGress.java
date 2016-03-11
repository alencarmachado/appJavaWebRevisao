package br.com.csi.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;



public class ConnectionFactoryPostGress {

	public static void main(String args[]) {
		System.out.println("INICA APP");
		insert();
		System.out.println("FIM APP");

	}

	public static Connection conexao() {
		Connection c = null;
		try {

			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tarefas", "postgres", "teste001");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
		return c;
	}

	public static void criaTabela() {
		Connection c = null;
		Statement stmt = null;
		try {
			 
			c = conexao();
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "CREATE TABLE TAREFA " + "(ID SERIAL PRIMARY KEY,"
					+ " DESCRICAO           VARCHAR(30)    NOT NULL, " + " FINALIZADO     BOOLEAN     NOT NULL, "
					+ " DATAFINALIZACAO  DATE) ";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}

	public static void insert() {
		Connection c = null;
		PreparedStatement stmt = null;
		try {

			c = conexao();
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			/*stmt = c.createStatement();
			String sql = "INSERT INTO TAREFA (ID, DESCRICAO, FINALIZADO, DATAFINALIZACAO) " + "VALUES (1, 'Ceva', 'baixa', 'hoje');";
			stmt.executeUpdate(sql);*/
			
			String sql = "INSERT INTO TAREFA (DESCRICAO, FINALIZADO, DATAFINALIZACAO) "
					+ " values (?,?,?)";
			
			stmt = c.prepareStatement(sql);
			
			stmt.setString(1, "tomar vinho");
			stmt.setBoolean(2, true);
			stmt.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.execute();
			
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}

	public static void select() {
		{
			Connection c = conexao();
			Statement stmt = null;
			try {

				c.setAutoCommit(false);
				System.out.println("Opened database successfully");

				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM TAREFA;");
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String prioridade = rs.getString("prioridade");
					String prazo = rs.getString("prazo");

					System.out.println("ID = " + id);
					System.out.println("NAME = " + name);
					System.out.println("prioridade = " + prioridade);
					System.out.println("prazo = " + prazo);

					System.out.println();
				}
				rs.close();
				stmt.close();
				c.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
			System.out.println("Operation done successfully");
		}
	}

	public static void update() {
		{
			Connection c = conexao();
			Statement stmt = null;
			try {

				c.setAutoCommit(false);
				System.out.println("Opened database successfully");

				stmt = c.createStatement();
				String sql = "UPDATE TAREFA set prioridade = 'alta' where ID=1;";
				stmt.executeUpdate(sql);
				c.commit();

				ResultSet rs = stmt.executeQuery("SELECT * FROM TAREFA;");
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String prioridade = rs.getString("prioridade");
					String prazo = rs.getString("prazo");

					System.out.println("ID = " + id);
					System.out.println("NAME = " + name);
					System.out.println("prioridade = " + prioridade);
					System.out.println("prazo = " + prazo);

					System.out.println();
				}
				rs.close();
				stmt.close();
				c.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
			System.out.println("Operation done successfully");
		}
	}

	public static void delete() {
		Connection c = conexao();
		Statement stmt = null;
		try {

			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "DELETE from TAREFA where ID=2;";
			stmt.executeUpdate(sql);
			c.commit();

			ResultSet rs = stmt.executeQuery("SELECT * FROM TAREFA;");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String prioridade = rs.getString("prioridade");
				String prazo = rs.getString("prazo");

				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("prioridade = " + prioridade);
				System.out.println("prazo = " + prazo);

				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}
}
