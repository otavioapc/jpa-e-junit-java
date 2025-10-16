package pr.senac.br.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pr.senac.br.modelo.Tarefa;

public class AdicionaTarefa {
	
	public static void main(String[] args) {
		
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Estudar Banco de Dados");
		tarefa.setFinalizado(false);
		tarefa.setDataConclusao(LocalDate.parse("2022-02-22"));
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_exemplo");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println(tarefa.toString());
		
		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();
		
		System.out.println(tarefa.toString());
		manager.close();

	}

}
