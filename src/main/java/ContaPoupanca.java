
public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupan�a ===");
		super.imprimirInfosComuns();
	}

	@Override
	public void verificarSaldoSuficiente(double valor) {
		if (getSaldo() < valor) {
			throw new IllegalArgumentException("Saldo insuficiente para realizar esta operação.");
		}
	}
}

