package banco.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private List<Conta> contas = new ArrayList<>();

	public void cadastrarConta(Conta conta) {
		ReceitaFederal receitaFederal = new ReceitaFederal();

		if (receitaFederal.verificarCPF(conta.getCpf())) {
			contas.add(conta);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public List<Conta> getContas() {
		return contas;
	}

}
