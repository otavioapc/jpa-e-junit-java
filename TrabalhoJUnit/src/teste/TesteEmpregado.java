package teste;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import aplicacao.Empregado;

public class TesteEmpregado {

	@Test
	public void testarCalculaINSS() {
		double resultado;		
		Empregado emp;
		emp = new Empregado(1000, 0);		
		resultado =  emp.calculaINSS();
		Assert.assertEquals(80, resultado, 0);
		emp = new Empregado(2500, 0);
		resultado = emp.calculaINSS();
		Assert.assertEquals(275, resultado, 0);
		emp = new Empregado(5000, 0);
		resultado = emp.calculaINSS();
		Assert.assertEquals(513.01, resultado, 0.01);
		emp = new Empregado(10000, 0);
		resultado = emp.calculaINSS();
		Assert.assertEquals(513.01, resultado, 0.01);
		emp = new Empregado(1500, 0);
		resultado = emp.calculaINSS();
		Assert.assertEquals(135, resultado, 0);
	}
	@Test
	public void testeCalculaIR() {
		double resultado;
		Empregado emp;
		//Sem dependentes
		emp = new Empregado(1000, 0);
		resultado = emp.calculaIR();
		Assert.assertEquals(0, resultado, 0);
		emp = new Empregado(2500, 0);
		resultado = emp.calculaIR();
		Assert.assertEquals(24.07, resultado, 0.01);
		emp = new Empregado(5000, 0);
		resultado = emp.calculaIR();
		Assert.assertEquals(373.44 , resultado, 0.01);
		emp = new Empregado(10000, 0);
		resultado = emp.calculaIR();
		Assert.assertEquals(1739.56 , resultado, 1);
		//Com dependentes
		emp = new Empregado(1000, 1);
		resultado = emp.calculaIR();
		Assert.assertEquals(0, resultado, 0);
		emp = new Empregado(2500, 1);
		resultado = emp.calculaIR();
		Assert.assertEquals(9.86, resultado, 0.01);
		emp = new Empregado(5000, 1);
		resultado = emp.calculaIR();
		Assert.assertEquals(330.78, resultado, 0.01);
		emp = new Empregado(10000, 1);
		resultado = emp.calculaIR();
		Assert.assertEquals(1687.42  , resultado, 1);
		emp = new Empregado(3500, 0);
		resultado = emp.calculaIR();
		Assert.assertEquals(112.45, resultado, 0.01);
	}
	@Test
	public void testeCalculaLiquido() {
		double resultado;
		Empregado emp;
		//Sem dependentes
		emp = new Empregado(1000, 0);
		resultado = emp.calculaLiquido();
		Assert.assertEquals(920.00, resultado, 0);
		emp = new Empregado(2500, 0);
		resultado = emp.calculaLiquido();
		Assert.assertEquals(2200.93, resultado, 0.01);
		emp = new Empregado(5000, 0);
		resultado = emp.calculaLiquido();
		Assert.assertEquals(4113.54, resultado, 0.01);
		emp = new Empregado(10000, 0);
		resultado = emp.calculaLiquido();
		Assert.assertEquals(7747.43, resultado, 1);
		//Com dependentes
		emp = new Empregado(1000, 1);
		resultado = emp.calculaLiquido();
		Assert.assertEquals(920.00, resultado, 0);
		emp = new Empregado(2500, 1);
		resultado = emp.calculaLiquido();
		Assert.assertEquals(2215.14, resultado, 0.01);
		emp = new Empregado(5000, 1);
		resultado = emp.calculaLiquido();
		Assert.assertEquals(4156.21, resultado, 0.01);
		emp = new Empregado(10000, 1);
		resultado = emp.calculaLiquido();
		Assert.assertEquals(7799.57, resultado, 1);
	}
	@Test
	public void testeGetESet() {
		double resultado;
		Empregado emp;
		emp = new Empregado(0, 0);
		emp.setSalario(1000);
		resultado = emp.getSalario();
		Assert.assertEquals(1000, resultado, 0);
		emp = new Empregado(5000, 0);
		emp.setNumFilhos(2);
		resultado = emp.getNumFilhos();
		Assert.assertEquals(2, resultado, 0);
	}

}