package org.example;

public class ProcessadorDePagamento {
    private InterfacePagamentoEstrategico estrategiaDePagamento;

    public ProcessadorDePagamento(InterfacePagamentoEstrategico estrategiaDePagamento) {
        this.estrategiaDePagamento = estrategiaDePagamento;
    }

    public void processar(double valor) {
        estrategiaDePagamento.processarPagamento(valor);
    }
}
