package pr.senac.br.jpa;

import java.util.ArrayList;
import java.util.Scanner;
import pr.senac.br.modelo.Tarefa;

public class Interface {

	Scanner entrada = new Scanner(System.in);

	public int menuPrincipal() {
		int op;
		Scanner entrada = new Scanner(System.in);

		System.out.println("------------------------------------");
		System.out.println("----------   MENU   ----------------");
		System.out.println("------------------------------------");
		System.out.println("1 - Incluir Tarefa ");
		System.out.println("2 - Consultar Tarefa por Codigo ");
		System.out.println("3 - Listar Tarefas ");
		System.out.println("4 - Excluir Tarefa ");
		System.out.println("5 - Concluir Tarefa ");

		System.out.println("10 - SAIR ");

		op = entrada.nextInt();

		while ((op > 5 && op != 10)   || op <= 0) {

			System.out.println("------------------------------------");
			System.out.println("----------   MENU   ----------------");
			System.out.println("------------------------------------");
			System.out.println("1 - Incluir Tarefa ");
			System.out.println("2 - Consultar Tarefa por Codigo  ");
			System.out.println("3 - Listar Tarefas ");
			System.out.println("4 - Excluir Tarefa ");
			System.out.println("5 - Concluir Tarefa ");

			System.out.println("10 - SAIR ");
			op = entrada.nextInt();

		}
		return op;
	}

	public Long lerCodigoTarefa() {

		return 0L;
	}
	
	
	public String lerDescricaoTarefa() {
		String descricao = "";
		Scanner ler = new Scanner(System.in);

		System.out.println("Informe a descri��o da tarefa");
		descricao = ler.nextLine();
		
		return descricao;
	}
	

	
	public void mostraTarefa(Tarefa tarefa) {
		
	}

	public void listarTarefas(ArrayList<Tarefa> tarefas) {
		
	}
	
	public void mostraMensagem(String msg) {
		System.out.println("-------------");
		System.out.println(msg);
		System.out.println("-------------");
	}
	
	

	/**
	 * Aqui vc cria um novo objeto Tarefa na tela, para depois tentar cadastrar
	 */
	public Tarefa novaTarefa() {

		
		return null;
	}




}

