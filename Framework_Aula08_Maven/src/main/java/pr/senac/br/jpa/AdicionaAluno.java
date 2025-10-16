package pr.senac.br.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import pr.senac.br.modelo.Aluno;


public class AdicionaAluno {
	
	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		aluno.setNome("Maria Clara Almeida");
		aluno.setCpf("12345678998");
		aluno.setRg("63675658");
		aluno.setEmail("maria@gmail.com");
		aluno.setAnoNascimento(2000);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_exemplo");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println(aluno.toString());
		
		try {
		
			manager.getTransaction().begin();
			manager.persist(aluno);
			manager.getTransaction().commit();
		
		}
		catch(PersistenceException e){
			
			System.out.println("Erro na inclusão do aluno: " + aluno.toString());
			System.out.println(e.getMessage());
			
		}
	
		manager.close();

	}

}
