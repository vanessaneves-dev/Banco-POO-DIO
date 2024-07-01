
public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}

	@Override
	public void verificarSaldoSuficiente(double valor) {
		if (getSaldo() < valor) {
			throw new IllegalArgumentException("Saldo insuficiente para realizar esta operação.");
		}
	}
	
}
