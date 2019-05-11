package banco.modelo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BancoTest {

    @Mock
    private ReceitaFederal receitaFederal;


    @Test
    public void deve_cadastrar_uma_conta_no_banco_quando_a_conta_for_valida() {
        Conta conta = new Conta();

        Banco banco = new Banco(receitaFederal);

        Assert.assertEquals(0, banco.getContas().size());
        when(receitaFederal.verificarCPF(conta.getCpf())).thenReturn(true);
        banco.cadastrarConta(conta);

        Assert.assertEquals(1, banco.getContas().size());
    }

    @Test
    public void deve_cadastrar_conta_quando_cpf_e_valido() {
        Conta conta = new Conta();
        conta.setCpf("90144924056");
        Banco banco = new Banco(receitaFederal);
        when(receitaFederal.verificarCPF(conta.getCpf())).thenReturn(true);
        banco.cadastrarConta(conta);

        Assert.assertEquals(1, banco.getContas().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_cadastrar_conta_quando_cpf_e_invalido() {
        Conta conta = new Conta();
        conta.setCpf("cpf invalido");

        Banco banco = new Banco(receitaFederal);
        when(receitaFederal.verificarCPF(conta.getCpf())).thenReturn(false);

        banco.cadastrarConta(conta);

        Assert.assertEquals(0, banco.getContas().size());

    }
    
    @Test
    public void deve_enviar_email_quando_conta_for_negativa() {
    	List<Conta> listaConta = Arrays.asList(new Conta(100, "1234"), new Conta(-50,"1234"),
    			new Conta(50,"1234"), new Conta(-200,"1234"));

    	Banco banco = spy(new Banco(new ReceitaFederal()));
    	
    	banco.notificarContasNegativas(listaConta);
    	
    	verify(banco, times(2)).enviarEmail();
    }

}
