package pr.senac.br.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pr.senac.br.modelo.Tarefa;

public class ExcluiTarefa {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_exemplo");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Tarefa encontrada = manager.find(Tarefa.class, 2L);				
		
		if(encontrada != null) {
			manager.remove(encontrada);
			System.out.println("Tarefa removida: " + encontrada.toString());
			
		}
		else {
			System.out.println("Tarefa não encontrada!");
		}
		
		manager.getTransaction().commit();
		
		manager.close();
		
	}

}
