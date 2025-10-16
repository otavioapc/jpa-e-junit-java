package pr.senac.br.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {
	
	//Atributos
	
	@Id
	@GeneratedValue (strategy  = GenerationType.IDENTITY)
	private int matricula;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 11, nullable = false, unique = true)
	private String cpf;
	
	@Column(length = 15, nullable = false, unique = true)
	private String rg;
	
	@Column(length = 100)
	private String email;
	
	@Column(nullable = false)
	private int anoNascimento;
	
	//Construtor
	
	public Aluno(int matricula, String nome, String cpf, String rg, String email, int anoNascimento) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.anoNascimento = anoNascimento;
	}
	
	public Aluno() {
		
	}
	
	//Métodos
	
	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", email=" + email
				+ ", anoNascimento=" + anoNascimento + "]";
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

}
