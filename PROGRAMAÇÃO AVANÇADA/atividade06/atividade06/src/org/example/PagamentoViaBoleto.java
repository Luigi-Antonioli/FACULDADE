package org.example;

public class PagamentoViaBoleto implements InterfacePagamentoEstrategico {
    @Override
    public void processarPagamento(double valor) {
        String codigoBoleto = gerarCodigoBoleto();
        System.out.println("Pagamento via Boleto realizado com sucesso!");
        System.out.println("Código do Boleto: " + codigoBoleto);
        System.out.println("Valor da transação: R$ " + valor);
    }

    private String gerarCodigoBoleto() {
        return "Boleto-" + (int)(Math.random() * 1000000); // Código de boleto fictício
    }
}
