package banco.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private List<Conta> contas = new ArrayList<>();

	private ReceitaFederal receitaFederal;

	Banco(ReceitaFederal receitaFederal){
		this.receitaFederal = receitaFederal;
	}


	public void cadastrarConta(Conta conta) {

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
