package pr.senac.br.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import pr.senac.br.modelo.Cliente;
import pr.senac.br.modelo.Conta;

public class AdicionaCliente {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		Cliente cliente;
		Conta conta;
		boolean laco = true;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_exemplo2");
		EntityManager manager = factory.createEntityManager();

		while (laco) {

			System.out.println("Deseja cadastrar um cliente?");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			int opcao = Integer.parseInt(teclado.nextLine());

			if (opcao == 1) {

				cliente = new Cliente();
				conta = new Conta();

				System.out.println("Informe o nome do cliente:");
				String nome = teclado.nextLine();
				System.out.println("Informe o CPF do cliente:");
				String cpf = teclado.nextLine();
				System.out.println("Informe o ano de nascimento:");
				int anoNascimento = Integer.parseInt(teclado.nextLine());
				System.out.println("Informe o email:");
				String email = teclado.nextLine();
				System.out.println("Informe o saldo:");
				double saldo = Double.parseDouble(teclado.nextLine());

				conta.setSaldo(saldo);
				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setAnoNascimento(anoNascimento);
				cliente.setEmail(email);
				cliente.setConta(conta);

				try {

					manager.getTransaction().begin();
					manager.persist(cliente);
					manager.getTransaction().commit();

				} catch (PersistenceException e) {

					System.out.println("Erro na inclusão do cliente: " + cliente.toString());
					System.out.println(e.getMessage());

				}

			} else if (opcao == 2) {
				laco = false;
			} else {

				System.out.println("Opção inexistente!");

			}

		}

	}

}
