package pr.senac.br.modelo3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Consultas {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_exemplo2");
		EntityManager manager = factory.createEntityManager();

		System.out.println("BUSCA 1");

		Query consulta1 = manager.createQuery("select p from Produto p");
		List<Produto> produtos = consulta1.getResultList();

		for (Produto prod : produtos) {
			System.out.println(prod.toString());
		}

		System.out.println("BUSCA 2");

		Query consulta2 = manager.createQuery("select p from Produto p where p.codigo = :id");
		consulta2.setParameter("id", 6);
		Produto prod = (Produto) consulta2.getSingleResult();
		System.out.println("Busca 2: " + prod.toString());

		System.out.println("BUSCA 3");

		Query consulta3 = manager.createQuery("select p from Produto p where p.preco >= :preco order by preco desc");
		consulta3.setParameter("preco", 10.0);
		List<Produto> produtos2 = consulta3.getResultList();
		for (Produto produto : produtos2) {
			System.out.println("Busca 3: " + produto.toString());

		}

		System.out.println("BUSCA 4");

		Query consulta4 = manager.createQuery("select p from Produto p where p.preco between :valorMin and :valorMax");
		consulta4.setParameter("valorMin", 10.0);
		consulta4.setParameter("valorMax", 30.0);
		List<Produto> produtos3 = consulta4.getResultList();
		for (Produto produto : produtos3) {
			System.out.println("Busca 4: " + produto.toString());

		}
		
		System.out.println("BUSCA 5");
		
		Query consulta5 = manager.createQuery("select p from Produto p where p.descricao like :nome");
		consulta5.setParameter("nome", "Arroz%");
		List<Produto> produtos4 = consulta5.getResultList();
		for(Produto produto : produtos4) {
			System.out.println("Busca 5: " + produto.toString());
		}
		
		System.out.println("BUSCA 6");
		
		Query consulta6 = manager.createQuery("select count(p) from Produto p where p.preco > :preco");
		consulta6.setParameter("preco", 30.0);
		Long contador = (Long)consulta6.getSingleResult();
		System.out.println("Quantidade: " + contador);
		
		System.out.println("BUSCA 7");
		
		Query consulta7 = manager.createQuery("select count(distinct p.descricao) from Produto p");
		Long contador1 = (Long)consulta7.getSingleResult();
		System.out.println("Quantidade: " + contador1);
		
		System.out.println("BUSCA 8");
		
		Query consulta8 = manager.createQuery("select p1 from Produto p1 where p1.preco >" + 
													"(select avg(p2.preco) from Produto p2)");
		
		List<Produto> produtos5 = consulta8.getResultList();
		for(Produto produto : produtos5) {
			System.out.println("Busca 6: " + produto.toString());
			
		}
		

		manager.close();

	}

}
