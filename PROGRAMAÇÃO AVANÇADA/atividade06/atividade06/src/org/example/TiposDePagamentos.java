package org.example;

public class TiposDePagamentos {

    public static InterfacePagamentoEstrategico criarPagamento(int tipoPagamento) {
        switch (tipoPagamento) {
            case 1:
                return new PagamentoViaPix();
            case 2:
                return new PagamentoCartaoDeCredito();
            case 3:
                return new PagamentoViaBoleto();
            default:
                throw new IllegalArgumentException("Tipo de pagamento inválido!");
        }
    }
}