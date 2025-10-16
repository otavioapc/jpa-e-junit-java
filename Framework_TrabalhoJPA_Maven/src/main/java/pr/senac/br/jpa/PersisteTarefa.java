package pr.senac.br.jpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import pr.senac.br.modelo.Tarefa;

/**
 * Classe que controla as Tarefas: permite cadastrar, alterar, excluir.
 * Faz o acesso ao banco de dados. 
 */

public class PersisteTarefa {

	private EntityManager manager;

	
	public PersisteTarefa() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_trabalho");
		manager = factory.createEntityManager();
	}

	
	public ArrayList<Tarefa> listarTodos() {
		return null;
	}

	
	public boolean cadastrarTarefa(Tarefa tarefa) {	
		
		boolean retorno;
		
		try {
			
			manager.getTransaction().begin();
			manager.persist(tarefa);
			manager.getTransaction().commit();
			retorno = true;
			
			
		}catch(PersistenceException e) {
			e.getMessage();
			retorno = false;
			
		}
		
		
		manager.close();
		
		

		return retorno;
	}

	public Tarefa buscarTarefaCodigo(Long codigo) {		
		
		return null;
	}
	
	
	public boolean excluirTarefa(Long codigo) {			
		return false;
	}
	

	public boolean concluirTarefa(Long codigo) {		

		return false;
	}
	

}