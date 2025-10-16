package pr.senac.br.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tarefas_registradas")
public class Tarefa {
	
	//Atributos
	
	@Id
	@GeneratedValue (strategy  = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	private boolean finalizado;
	private LocalDate dataConclusao;
	
	@Transient
	private String responsavel;
	
	//Construtor
	
	public Tarefa(Long id, String descricao, boolean finalizado, LocalDate dataConclusao, String responsavel) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.finalizado = finalizado;
		this.dataConclusao = dataConclusao;
		this.responsavel = responsavel;
	}
	
	public Tarefa() {
		
	}
	
	//Métodos	

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", descricao=" + descricao + ", finalizado=" + finalizado + ", dataConclusao="
				+ dataConclusao + ", responsavel=" + responsavel + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	
}
