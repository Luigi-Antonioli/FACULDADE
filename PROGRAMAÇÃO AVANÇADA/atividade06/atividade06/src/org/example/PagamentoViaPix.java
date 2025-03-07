package org.example;

import java.util.Random;

public class PagamentoViaPix implements InterfacePagamentoEstrategico {
    @Override
    public void processarPagamento(double valor) {
        String codigoPix = gerarCodigoPix();
        System.out.println("Pagamento via Pix realizado com sucesso!");
        System.out.println("Código do Pix: " + codigoPix);
        System.out.println("Valor da transação: R$ " + valor);
    }

    private String gerarCodigoPix() {
        Random random = new Random();
        return "PIX" + random.nextInt(1000000000); // Código de Pix fictício
    }
}
