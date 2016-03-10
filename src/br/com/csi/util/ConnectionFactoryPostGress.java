package br.com.csi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactoryPostGress {

	public static void main(String args[]) {
		System.out.println("INICA APP");
		delete();
		System.out.println("FIM APP");

	}

	public static Connection conexao() {
		Connection c = null;
		try {

			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/internetc", "postgres", "teste001");

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
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/internetc", "postgres", "123");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "CREATE TABLE TAREFA " + "(ID INT PRIMARY KEY     NOT NULL,"
					+ " NAME           VARCHAR(30)    NOT NULL, " + " PRIORIDADE     VARCHAR(30)     NOT NULL, "
					+ " PRAZO          VARCHAR(30)) ";
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
		Statement stmt = null;
		try {

			c = conexao();
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "INSERT INTO TAREFA (ID,NAME, PRIORIDADE, PRAZO) " + "VALUES (1, 'Ceva', 'baixa', 'hoje');";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO TAREFA (ID,NAME, PRIORIDADE, PRAZO) " + "VALUES (2, 'carne', 'media', 'amanha');";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO TAREFA (ID,NAME, PRIORIDADE, PRAZO) " + "VALUES (3, 'Ceva1', 'baixa', 'hoje1');";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO TAREFA (ID,NAME, PRIORIDADE, PRAZO) " + "VALUES (4, 'Ceva2', 'baixa', 'hoje2');";
			stmt.executeUpdate(sql);

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
