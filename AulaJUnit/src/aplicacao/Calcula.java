package aplicacao;

public class Calcula {

	// Métodos

	public double somar(double n1, double n2) {

		return n1 + n2;

	}

	public double subtrair(double n1, double n2) {

		return n1 - n2;

	}

	public double multiplicar(double n1, double n2) {

		return n1 * n2;

	}

	public String par_impar(int numero) {
		String resultado;

		if (numero % 2 == 0 && numero >= 0) {
			resultado = "PAR";

		} else if (numero < 0) {
			resultado = null;

		} else {
			resultado = "IMPAR";

		}

		return resultado;

	}

	public boolean maior(double n1, double n2) {

		if (n1 >= n2) {
			return true;
		} else {
			return false;
		}

	}
	
	

}
