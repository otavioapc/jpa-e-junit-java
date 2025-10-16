package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados {

	// Atributos

	private Connection connection = null; // gerencia a conexão com o banco de dados
	private Statement statement = null; // gerencia os comandos (querys) enviadas ao Banco de Dados
	private ResultSet resultset = null; // armazena o retorno de uma query de consulta (SELECT) no banco de dados

	// Métodos

	public void conectar() {
		String servidor = "jdbc:mysql://192.168.56.101:3306/agenda";
		String usuario = "usuario";
		String senha = "usuario";

		try {
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();

		} catch (Exception e) {
			System.out.println("Erro de conexão com o Banco de Dados!");
			System.out.println(e.getMessage());

		}

	}

	public boolean estarConectado() {

		if (this.connection != null) {
			return true;
		} else {
			return false;
		}

	}

	public void inserirContato(String nome, String telefone) {
		String query;

		try {
			query = "INSERT INTO contato (nome, telefone) VALUES ('" + nome + "', '" + telefone + "');";
			this.statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Erro na Inserção");
			System.out.println(e.getMessage());

		}

	}

	public void listarContato() {
		String query;

		try {
			query = "SELECT * FROM contato ORDER BY nome";
			this.resultset = statement.executeQuery(query);

			while (this.resultset.next()) {
				System.out.println("Codigo: " + this.resultset.getString("id"));
				System.out.println("Nome: " + this.resultset.getString("nome"));
				System.out.println("Telefone: " + this.resultset.getString("telefone"));

			}

		} catch (Exception e) {
			System.err.println("Erro no SELECT");
			System.out.println(e.getMessage());

		}

	}

	public void apagarContato(String id) {
		String query;

		try {
			query = "DELETE FROM contato WHERE id = " + id;
			this.statement.executeUpdate(query);

		} catch (Exception e) {
			System.err.println("Erro na EXCLUSÃO");
			System.out.println(e.getMessage());

		}

	}
	
	public void atualizarContato(String id, String nome, String telefone) {
		String query;
		
		try {
			query = "UPDATE contato SET nome = '" + nome + "', telefone = '" + telefone + "' WHERE id = " + id + ";";
			this.statement.executeUpdate(query);
			
		}catch(Exception e) {
			System.err.println("Erro na ATUALIZAÇÃO");
			System.out.println(e.getMessage());
			
		}
		
		
		
		
	}

}
