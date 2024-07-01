import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        banco.setNome("DIOBank");
        System.out.println("Seja bem-vindo ao banco " + banco.getNome());

        ListaDados listaClientes = new ListaDados();

        Cliente clienteLogado = null;
        while (clienteLogado == null) {
            System.out.println("Digite o nome do titular da conta que deseja acessar: ");
            String nome = scanner.nextLine();
            clienteLogado = listaClientes.buscarPorNome(nome);

            if (clienteLogado == null) {
                System.out.println("Cliente não encontrado. Verifique o nome digitado.");
            }
        }

        int opcaoDesejada = -1;
        while (opcaoDesejada != 0) {
            System.out.println("Olá, " + clienteLogado.getNome() + "! Você está logado.");
            banco.menu();

            System.out.println("Digite a opção desejada:");
            opcaoDesejada = scanner.nextInt();
            scanner.nextLine(); // Para consumir o "\n" restante

            switch (opcaoDesejada) {
                case 0:
                    System.out.println("Obrigado por usar o DIOBank!");
                    break;
                case 1:
                    System.out.println("Seu saldo na conta corrente é de R$ " + clienteLogado.getCc().getSaldo());
                    break;
                case 2:
                    System.out.println("Seu saldo na conta poupança é de R$ " + clienteLogado.getPoupanca().getSaldo());
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja depositar na conta corrente:");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    clienteLogado.getCc().depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso. Saldo atual: R$ " + clienteLogado.getCc().getSaldo());
                    break;
                case 4:
                    System.out.println("Digite o valor que deseja sacar da conta corrente:");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();
                    clienteLogado.getCc().verificarSaldoSuficiente(valorSaque);
                    clienteLogado.getCc().sacar(valorSaque);
                    System.out.println("Saque realizado com sucesso. Saldo atual: R$ " + clienteLogado.getCc().getSaldo());
                    break;
                case 5:
                    System.out.println("Digite o valor que deseja transferir da conta corrente (seu saldo disponível é de R$ "
                            + clienteLogado.getCc().getSaldo() + "):");
                    double valorTransferir = scanner.nextDouble();
                    scanner.nextLine();
                    clienteLogado.getCc().verificarSaldoSuficiente(valorTransferir);

                    System.out.println("Digite o nome do cliente de destino:");
                    String nomeDestino = scanner.nextLine();
                    Cliente clienteDestino = listaClientes.buscarPorNome(nomeDestino);
                    if (clienteDestino == null) {
                        System.out.println("Cliente de destino não encontrado. Operação cancelada.");
                    } else {
                        clienteLogado.getCc().transferir(valorTransferir, clienteDestino.getCc());
                        System.out.println("Transferência realizada com sucesso. Saldo restante: R$ " + clienteLogado.getCc().getSaldo());
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }

        scanner.close();
    }
}
