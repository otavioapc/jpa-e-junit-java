package aplicacao;

public class Empregado {

	// Atributos

	private double salario;
	private int numFilhos;

	// Construtor

	public Empregado(double salario, int numFilhos) {
		super();
		this.salario = salario;
		this.numFilhos = numFilhos;
	}

	// Métodos

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getNumFilhos() {
		return numFilhos;
	}

	public void setNumFilhos(int numFilhos) {
		this.numFilhos = numFilhos;
	}

	public double calculaINSS() {

		if (salario <= 1399.12) {
			return salario * 0.08;

		} else if (salario >= 1399.13 && salario <= 2331.88) {
			return salario * 0.09;

		} else if(salario >= 2331.89 && salario <= 4663.75){
			return salario * 0.11;
			
		}
		else {
			return 4663.75 * 0.11;
			
		}

	}

	public double calculaIR() {
		double salarioBaseIR = salario - calculaINSS() - (189.59 * numFilhos);

		if (salarioBaseIR <= 1903.98) {
			return 0;

		} else if (salarioBaseIR >= 1903.99 && salarioBaseIR <= 2826.65) {
			return (salarioBaseIR * 0.075) - 142.80;

		} else if (salarioBaseIR >= 2826.66 && salarioBaseIR <= 3751.05) {
			return (salarioBaseIR * 0.15) - 354.80;

		} else if (salarioBaseIR >= 3751.06 && salarioBaseIR <= 4664.68) {
			return (salarioBaseIR * 0.225) - 636.13;

		} else {
			return (salarioBaseIR * 0.275) - 869.13;

		}

	}
	
	public double calculaLiquido() {
		
		return salario - calculaINSS() - calculaIR();
		
	}

 
}
