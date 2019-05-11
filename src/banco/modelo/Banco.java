package banco.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private List<Conta> contas = new ArrayList<>();

	private final ReceitaFederal receitaFederal;

	Banco(ReceitaFederal receitaFederal) {
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

	public void notificarContasNegativas(List<Conta> listaConta) {
		for (Conta conta : listaConta) {
			if (conta.getSaldo() < 0) {
				enviarEmail();
			}
		}

	}

	public void enviarEmail() {

		System.out.println("Enviando email.....");
	}

}
