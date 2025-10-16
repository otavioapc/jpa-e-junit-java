package pr.senac.br.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Funcionario {
	
	//Atributos
	
	@Id
	@Column (length = 11)
	private String cpf;
	
	@Column (nullable = false, length = 60)
	private String nome;
	
	@Column (length = 40, unique = true, nullable = false)
	private String email;
	
	@Column (nullable = false)
	private double salario;
	
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn (name = "cpf_funcionario")
	private List<ClienteEmpresa> clientes;
	
	//Construtor
	
	public Funcionario(String cpf, String nome, String email, double salario, List<ClienteEmpresa> clientes) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.salario = salario;
		this.clientes = clientes;
	}
	
	public Funcionario() {
		
		
	}
	
	//Métodos
	
	@Override
	public String toString() {
		return "Funcionario [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", salario=" + salario
				+ ", clientes=" + clientes + "]";
	}
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ClienteEmpresa> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteEmpresa> clientes) {
		this.clientes = clientes;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	
}
