package banco.modelo;

import org.junit.Assert;
import org.junit.Test;

public class BancoTest {

	@Test
	public void deve_cadastrar_uma_conta_no_banco_quando_a_conta_for_valida() {
		Conta conta = new Conta();
		
		Banco banco = new Banco();
		
		Assert.assertEquals(0, banco.getContas().size());
		
		banco.cadastrarConta(conta);
		
		Assert.assertEquals(1, banco.getContas().size());
	}
	
	@Test
	public void deve_cadastrar_conta_quando_cpf_e_valido(){
		Conta conta = new Conta();
		conta.setCpf("123456");
		Banco banco = new Banco();
		
		banco.cadastrarConta(conta);
	
		Assert.assertEquals(1, banco.getContas().size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nao_deve_cadastrar_conta_quando_cpf_e_invalido(){
		Conta conta = new Conta();
		conta.setCpf("cpf invalido");
		Banco banco = new Banco();
		
		banco.cadastrarConta(conta);
	
	}

}
