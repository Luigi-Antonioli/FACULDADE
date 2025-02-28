package org.example;

class ContaInvestimentoAltoRisco extends ContaInvestimento {

    public ContaInvestimentoAltoRisco(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= 10000) {
            double valorComTaxa = valor * 1.05;  // 5% de taxa
            if (valorComTaxa <= saldo) {
                saldo -= valorComTaxa;
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println("Saldo mínimo de R$ 10.000,00 para saque!");
        }
    }
}

