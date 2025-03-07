package org.example;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exibe as opções de pagamento
        System.out.println("Bem-vindo ao sistema de pagamentos!");
        System.out.println("Escolha o método de pagamento:");
        System.out.println("1: Pix");
        System.out.println("2: Cartão de Crédito");
        System.out.println("3: Boleto");

        // Lê a escolha do usuário
        int opcao = scanner.nextInt();

        // Solicita o valor da transação
        System.out.println("Digite o valor da transação (ex: 100.00): ");
        double valor = scanner.nextDouble();

        ProcessoDePagamento metodoDePagamento = null;

        // Definir a estratégia com base na escolha do usuário
        switch (opcao) {
            case 1:
                metodoDePagamento = new PagamentoViaPix();
                break;
            case 2:
                metodoDePagamento = new PagamentoViaCartaoDeCredito();
                break;
            case 3:
                metodoDePagamento = new PagamentoViaBoleto();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                scanner.close();
                return; // Termina o programa em caso de erro
        }

        // Processa o pagamento
        TiposDePagamentos processador = new TiposDePagamentos(metodoDePagamento);
        processador.processar(valor);

        // Mensagem final
        System.out.println("Transação processada com sucesso! Obrigado.");
        scanner.close();
    }
}
