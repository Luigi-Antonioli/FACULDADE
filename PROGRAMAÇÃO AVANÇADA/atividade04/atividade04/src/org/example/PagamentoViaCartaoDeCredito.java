package org.example;

import java.util.Scanner;

public class PagamentoViaCartaoDeCredito implements ProcessoDePagamento {
    @Override
    public void processarPagamento(double valor) {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário um número fictício de cartão
        System.out.println("Digite o número do cartão de crédito (fictício): ");
        String numeroCartao = scanner.nextLine();

        System.out.println("Pagamento via Cartão de Crédito realizado com sucesso!");
        System.out.println("Número do Cartão: " + numeroCartao);
        System.out.println("Valor da transação: R$ " + valor);
    }
}
