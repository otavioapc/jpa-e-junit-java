package teste;

import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import aplicacao.Calcula;

public class CalculaTeste {
	
	@Test
	public void testeSomar() {
		double resultado;
		
		Calcula calc = new Calcula();
		
		resultado = calc.somar(10, 5);		
		Assert.assertEquals(15, resultado, 0);
		
		resultado = calc.somar(3, -5);		
		Assert.assertEquals(-2, resultado, 0);
		
		resultado = calc.somar(-15, 30);		
		Assert.assertEquals(15, resultado, 0);
		
		resultado = calc.somar(-5, -8);		
		Assert.assertEquals(-13, resultado, 0);
		
		
	}
	
	@Test
	public void testeSubtrair() {
		double resultado;
		
		Calcula calc = new Calcula();
		
		resultado = calc.subtrair(10, 5);
		Assert.assertEquals(5, resultado, 0);
		
		resultado = calc.subtrair(13, -5);
		Assert.assertEquals(18, resultado, 0);
		
		resultado = calc.subtrair(-15, 30);
		Assert.assertEquals(-45, resultado, 0);
		
		resultado = calc.subtrair(-5, -8);
		Assert.assertEquals(3, resultado, 0);
		
	}
	
	@Test
	public void testeMultiplicar() {
		double resultado;
		
		Calcula calc = new Calcula();
		
		resultado = calc.multiplicar(8, 8);
		Assert.assertEquals(64, resultado, 0);
		
		resultado = calc.multiplicar(5, -5);
		Assert.assertEquals(-25, resultado, 0);
		
		resultado = calc.multiplicar(-2, 2);
		Assert.assertEquals(-4, resultado, 0);
		
		resultado = calc.multiplicar(-6, -6);
		Assert.assertEquals(36, resultado, 0);
		
		resultado = calc.multiplicar(-6, 0);
		Assert.assertEquals(0, resultado, 0);
				
	}
	
	@Test
	public void testeSubtraiDecimal() {
		double resultado;
		
		Calcula calc = new Calcula();
		
		resultado = calc.subtrair(10.3, 4.1);
		//O terceiro parâmetro indica o delta(variação do valor pra cima ou pra baixo)
		Assert.assertEquals(6.2, resultado, 0.000001);
		
	}
	
	@Test
	public void testeParImpar() {
		String resultado;
		
		Calcula calc = new Calcula();
		
		resultado = calc.par_impar(0);
		Assert.assertEquals("PAR", resultado);
		
		resultado = calc.par_impar(5);		
		Assert.assertEquals("IMPAR", resultado);
		
		resultado = calc.par_impar(-5);		
		Assert.assertNull(resultado);
		
		
	}
	
	@Test
	public void testeMaior() {
		boolean resultado;
		
		Calcula calc = new Calcula();
		
		resultado = calc.maior(10.3, 9.5);
		Assert.assertTrue(resultado);
		
		resultado = calc.maior(2.2, 9.9);
		Assert.assertFalse(resultado);
		
		
	}
	
	@Before
	public void before() {
		
		System.out.println("Iniciando os testes da classe Calculo para método específico");
		
	}
	
	@After
	public void after() {
		
		System.out.println("Finalizando os testes da classe Calculo para método específico");
			
	}
	
	@BeforeClass
	public static void beforeClass() {
		
		System.out.println("Iniciando os testes da classe Calculo");
		
	}
	
	@AfterClass
	public static void afterClass() {
		
		System.out.println("Finalizando os testes da classe Calculo" );
		
	}
	
}
