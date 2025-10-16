package pr.senac.br.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClienteEmpresa {
	
	//Atributos
	
	@Id
	@Column (length = 11)
	private String cpf;
	
	@Column (nullable = false)
	private int anoNascimento;
	
	@Column (length = 60, nullable = false)
	private String nome;
	
	@Column (length = 40, unique = true, nullable = false)
	private String email;
	
	//Construtor
	
	public ClienteEmpresa(String cpf, int anoNascimento, String nome, String email) {
		super();
		this.cpf = cpf;
		this.anoNascimento = anoNascimento;
		this.nome = nome;
		this.email = email;
	}
	
	public ClienteEmpresa() {
		
		
	}
	
	//Métodos

	@Override
	public String toString() {
		return "ClienteEmpresa [cpf=" + cpf + ", anoNascimento=" + anoNascimento + ", nome=" + nome + ", email=" + email
				+ "]";
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
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

}
