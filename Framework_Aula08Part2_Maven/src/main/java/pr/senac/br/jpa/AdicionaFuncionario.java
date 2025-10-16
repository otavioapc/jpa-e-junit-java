package pr.senac.br.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import pr.senac.br.modelo.ClienteEmpresa;
import pr.senac.br.modelo.Funcionario;
import pr.senac.br.modelo3.Produto;

public class AdicionaFuncionario {

	public static void main(String[] args) {

		ClienteEmpresa clienteEmpresa;
		Funcionario funcionario;
		ArrayList<ClienteEmpresa> clientes;

		Scanner teclado = new Scanner(System.in);
		boolean lacoFuncionario = true;
		boolean lacoCliente = true;
		int opcaoFuncionario = 0;
		int opcaoCliente = 0;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_exemplo2");
		EntityManager manager = factory.createEntityManager();

		while (lacoFuncionario) {

			System.out.println("Deseja cadastrar um Funcionário?");
			System.out.println("Sim - 1");
			System.out.println("Não - 2");
			opcaoFuncionario = Integer.parseInt(teclado.nextLine());
			if (opcaoFuncionario == 1) {
				funcionario = new Funcionario();
				clientes = new ArrayList<ClienteEmpresa>();

				System.out.println("Informe o CPF:");
				String cpf = teclado.nextLine();
				System.out.println("Informe o nome:");
				String nome = teclado.nextLine();
				System.out.println("Informe o email:");
				String email = teclado.nextLine();
				System.out.println("informe o salário:");
				double salario = Double.parseDouble(teclado.nextLine());

				funcionario.setCpf(cpf);
				funcionario.setNome(nome);
				funcionario.setEmail(email);
				funcionario.setSalario(salario);

				lacoCliente = true;

				while (lacoCliente) {

					System.out.println("Deseja cadastrar um cliente?");
					System.out.println("Sim - 1");
					System.out.println("Não - 2");
					opcaoCliente = Integer.parseInt(teclado.nextLine());
					if (opcaoCliente == 1) {

						clienteEmpresa = new ClienteEmpresa();

						System.out.println("Informe o CPF:");
						String cpfCli = teclado.nextLine();
						System.out.println("Informe o nome:");
						String nomeCli = teclado.nextLine();
						System.out.println("Informe o ano de Nascimento:");
						int anoNascimento = Integer.parseInt(teclado.nextLine());
						System.out.println("Informe o email:");
						String emailCli = teclado.nextLine();

						clienteEmpresa.setCpf(cpfCli);
						clienteEmpresa.setNome(nomeCli);
						clienteEmpresa.setAnoNascimento(anoNascimento);
						clienteEmpresa.setEmail(emailCli);

						clientes.add(clienteEmpresa);
					} else if (opcaoCliente == 2) {

						funcionario.setClientes(clientes);

						try {

							manager.getTransaction().begin();
							manager.persist(funcionario);
							manager.getTransaction().commit();

						} catch (PersistenceException e) {

							System.out.println("Erro na inclusão do cliente: " + funcionario.toString());
							System.out.println(e.getMessage());

						}

						lacoCliente = false;

					} else {
						System.err.println("Opção não disponível!");

					}

				}

			} else if (opcaoFuncionario == 2) {
				lacoFuncionario = false;
			} else {
				System.err.println("Opção não disponível!");

			}

		}

		System.out.println("Classe social do funcionário");

		System.out.println("Classe A");
		Query classeA = manager.createQuery("select f from Funcionario f where f.salario > :valorMin");
		classeA.setParameter("valorMin", 24800.0);
		List<Funcionario> funcionarioA = classeA.getResultList();
		for (Funcionario funcionario1 : funcionarioA) {
			System.out.println(funcionario1.toString());

		}

		System.out.println("Classe B");
		Query classeB = manager
				.createQuery("select f from Funcionario f where f.salario between :valorMin and :valorMax");
		classeB.setParameter("valorMin", 7017.0);
		classeB.setParameter("valorMax", 24800.0);
		List<Funcionario> funcionarioB = classeB.getResultList();
		for (Funcionario funcionario1 : funcionarioB) {
			System.out.println(funcionario1.toString());

		}

		System.out.println("Classe C");
		Query classeC = manager
				.createQuery("select f from Funcionario f where f.salario between :valorMin and :valorMax");
		classeC.setParameter("valorMin", 3300.0);
		classeC.setParameter("valorMax", 8000.0);
		List<Funcionario> funcionarioC = classeC.getResultList();
		for (Funcionario funcionario1 : funcionarioC) {
			System.out.println(funcionario1.toString());

		}

		System.out.println("Classe D e E");
		Query classeDE = manager.createQuery("select f from Funcionario f where f.salario <= :valorMax");
		classeDE.setParameter("valorMax", 3300.0);
		List<Funcionario> funcionarioDE = classeDE.getResultList();
		for (Funcionario funcionario1 : funcionarioDE) {
			System.out.println(funcionario1.toString());

		}

		manager.close();

	}

}
