package banco.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContaTest {
	
	private Conta c;
	@Before
	public void iniciar(){
		c = new Conta();
	}

	@Test
	public void deve_depositar_valor_em_uma_conta_quando_for_positivo() {
		// Entrada
		// Execução
		c.depositar(100);
		// Saída
		Assert.assertEquals(100, c.getSaldo(), 0.001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_depositar_valores_negativos() {
		// Entrada
		// Execução
		c.depositar(50);
		c.depositar(-100);
		// Saída
		Assert.assertEquals(50, c.getSaldo(), 0.001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_depositar_valores_zerados() {
		// Entrada
		// Execução
		c.depositar(0);
	}

	@Test
	public void deve_sacar_quando_saldo_maior_que_valor() {
		// Entrada
		// Execução
		c.depositar(150);
		c.sacar(100);
		// Saída
		Assert.assertEquals(50, c.getSaldo(), 0.001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_sacar_valor_negativo() {
		// Entrada

		// Execução
		c.sacar(-100);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_sacar_valor_zerado() {
		//Entrada
		
		//Execução
		c.sacar(0);
	}
	
	@Test
	public void deve_transferir_valor_positivo() {
		// Entrada
		Conta c1 = new Conta();
		Conta c2 = new Conta();
		// Execução
		c1.depositar(100);
		c1.transferir(c2, 100);
		// Saida
		Assert.assertEquals(0, c1.getSaldo(), 0.001);
		Assert.assertEquals(100, c2.getSaldo(), 0.001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_transferir_valor_negativo() {
		// Entrada
		Conta c1 = new Conta();
		Conta c2 = new Conta();
		// Execução
		c1.transferir(c2, -100);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_transferir_valor_zerado() {
		// Entrada
		Conta c1 = new Conta();
		Conta c2 = new Conta();
		// Execução
		c1.transferir(c2, 0);
	}
	

}
