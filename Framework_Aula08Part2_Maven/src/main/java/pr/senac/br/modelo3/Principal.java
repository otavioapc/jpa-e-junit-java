package pr.senac.br.modelo3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class Principal {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_exemplo2");
		EntityManager manager = factory.createEntityManager();

		Produto produto1 = new Produto("Arroz Branco", 15.90);
		Produto produto2 = new Produto("Arroz Integral", 17.49);
		Produto produto3 = new Produto("Feijão", 7.90);
		Produto produto4 = new Produto("Leite", 5.70);
		Produto produto5 = new Produto("Tomate", 9.80);
		Produto produto6 = new Produto("Carne Bovina", 35.40);
		Produto produto7 = new Produto("Frango", 18.90);
		Produto produto8 = new Produto("Carne Suina", 23.75);
		Produto produto9 = new Produto("Batata", 8.50);

		try {

			manager.getTransaction().begin();
			manager.persist(produto1);
			manager.persist(produto2);
			manager.persist(produto3);
			manager.persist(produto4);
			manager.persist(produto5);
			manager.persist(produto6);
			manager.persist(produto7);
			manager.persist(produto8);
			manager.persist(produto9);
			manager.getTransaction().commit();

		} catch (PersistenceException e) {

			System.out.println(e.getMessage());

		}

	}

}
