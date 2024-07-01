public class Cliente {

	private String nome;
	private Conta cc;
	private Conta poupanca;

	public Cliente(String nome, Conta cc, Conta poupanca) {
		this.nome = nome;
		this.cc = cc;
		this.poupanca = poupanca;

		// Atribuir o cliente às contas
		if (cc != null) cc.setCliente(this);
		if (poupanca != null) poupanca.setCliente(this);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Conta getCc() {
		return cc;
	}

	public Conta getPoupanca() {
		return poupanca;
	}
}
