package banco.modelo;

public class Conta {

	private double saldo;

	public void depositar(double valor) {
		if (verificaValor(valor)) {
			this.saldo += valor;
		}
	}

	public double getSaldo() {
		return saldo;
	}

	public Boolean verificaValor(double valor) {
		if (valor > 0) {
			return true;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void sacar(double valor) {
		if (verificaValor(valor)) {
			this.saldo -= valor;
		}
	}

	public void transferir(Conta destino, double valor) {
		if (verificaValor(valor) && verificaSaldo(this.getSaldo(), valor)) {
			this.sacar(valor);
			destino.depositar(valor);
		}

	}

	private boolean verificaSaldo(double saldo, double valor) {
		if (saldo >= valor) {
			return true;
		} else {
			return false;
		}
	}
}
