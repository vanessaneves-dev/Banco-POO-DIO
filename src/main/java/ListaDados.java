import java.util.Arrays;
import java.util.List;

public class ListaDados {
  List<Cliente> listaDado;

  public ListaDados() {
    listaDado = Arrays.asList(
        new Cliente("Joao", new ContaCorrente(null), new ContaPoupanca(null)),
        new Cliente("Maria", new ContaCorrente(null), new ContaPoupanca(null)),
        new Cliente("Enzo", new ContaCorrente(null), new ContaPoupanca(null)),
        new Cliente("Valentina", new ContaCorrente(null), new ContaPoupanca(null)),
        new Cliente("Livia", new ContaCorrente(null), new ContaPoupanca(null)));
  }

  public Cliente buscarPorNome(String nome) {
    for (Cliente c : listaDado) {
      if (nome.equalsIgnoreCase(c.getNome())) {
        return c;
      }
    }
    return null;
  }

  public void transferir(Cliente clienteOrigem, double valor, Cliente clienteDestino) {
    clienteOrigem.getCc().sacar(valor);
    clienteDestino.getCc().depositar(valor);
  }
}
