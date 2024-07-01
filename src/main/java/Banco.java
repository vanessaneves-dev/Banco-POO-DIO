import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	// Menu simplificado com opções básicas
	public void menu() {
		System.out.println("0 - Sair");
		System.out.println("1 - Ver saldo da conta corrente");
		System.out.println("2 - Ver saldo da conta poupança");
		System.out.println("3 - Depositar na conta corrente");
		System.out.println("4 - Sacar da conta corrente");
		System.out.println("5 - Transferir para outra conta");
	}
}
