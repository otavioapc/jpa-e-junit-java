package pr.senac.br.jpa;

import java.util.ArrayList;

import pr.senac.br.modelo.Tarefa;

public class Principal {

	public static void main(String[] args) {
		
		Interface               inter = new Interface();       // Classe que representa a Interface do sistema  
		PersisteTarefa persisteTarefa = new PersisteTarefa();  // Classe de de Persistencia de tarefa

		int opMenu;
		Long codigo_busca;
		
		opMenu = inter.menuPrincipal();

		while (opMenu != 10) {

			switch (opMenu) {
			case 1: // Cadastrar Tarefa

				Tarefa tarefa = inter.novaTarefa();  // Chamo a interface para o cadastro do ALuno
				if (persisteTarefa.cadastrarTarefa(tarefa)) {
					inter.mostraMensagem("Tarefa Cadastrado com sucesso");
					inter.mostraTarefa(tarefa);
				} else {
					inter.mostraMensagem("Tarefa N�O cadastrada");
					inter.mostraTarefa(tarefa);
				}
				break;
				
			case 2: // Consultar Tarefa
				codigo_busca = inter.lerCodigoTarefa();
				
				Tarefa tarefa_busca = persisteTarefa.buscarTarefaCodigo(codigo_busca);
				if (tarefa_busca == null) {
					inter.mostraMensagem("Tarefa com codigo  " + codigo_busca + " nao encontrada");
				}
				else {
					inter.mostraMensagem("Tarefa cadastrada");
					inter.mostraTarefa(tarefa_busca);
				}
								
				break;
				

			case 3: // Listar Tarefa
				ArrayList<Tarefa> tarefasCadastradss = persisteTarefa.listarTodos();
				inter.mostraMensagem("Listar alunos cadastrados");
				inter.listarTarefas(tarefasCadastradss);
				break;

				
			case 4:		// Excluir tarefa		
				codigo_busca = inter.lerCodigoTarefa();			
				if (persisteTarefa.excluirTarefa(codigo_busca)) {
					System.out.println("Tarefa excluida");
				}
				else {
					System.out.println("Tarefa NAO excluida");
				}
				break;
				
			case 5:	  // Concuir tarefa			
				codigo_busca = inter.lerCodigoTarefa();
				
				if(persisteTarefa.concluirTarefa(codigo_busca)) {
					System.out.println("Tarefa conclu�da");
				}
				else {
					System.out.println("Tarefa NAO conclu�da");
				}
				break;
				
			}
			
			opMenu = inter.menuPrincipal();
		}
		
		inter.mostraMensagem("SAIR - Sistema encerrado");
		

	}

}
