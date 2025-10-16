package pr.senac.br.modelo3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	//Atributos
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column (length = 50, nullable = false)
	private String descricao;
	
	@Column (nullable = false)
	private double preco;
	
	//Construtor
	
	public Produto(String descricao, double preco) {
		super();
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public Produto() {
		
	}
	
	//Métodos

	@Override
	public String toString() {
		return "Produto [codigo= " + codigo + ", descricao= " + descricao + ", preco= " + preco + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
