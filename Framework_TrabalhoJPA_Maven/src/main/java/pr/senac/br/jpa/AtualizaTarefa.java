package pr.senac.br.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pr.senac.br.modelo.Tarefa;

public class AtualizaTarefa {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_exemplo");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Tarefa encontrada = manager.find(Tarefa.class, 1L);		
		encontrada.setDescricao("Estudar Banco de Dados");
		encontrada.setFinalizado(true);
		encontrada.setDataConclusao(LocalDate.parse("2022-05-22"));
		
		manager.merge(encontrada);
		manager.getTransaction().commit();
		
		manager.close();
	}

}
