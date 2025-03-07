package org.example;

public class TiposDePagamentos {
    private ProcessoDePagamento estrategiaDePagamento;

    // Recebe uma estratégia de pagamento e a executa
    public TiposDePagamentos(ProcessoDePagamento estrategiaDePagamento) {
        this.estrategiaDePagamento = estrategiaDePagamento;
    }

    public void processar(double valor) {
        estrategiaDePagamento.processarPagamento(valor); // Chama o método da estratégia de pagamento
    }
}