package org.example;

class ContaInvestimento extends ContaBancaria {

    public ContaInvestimento(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        double valorComTaxa = valor * 1.02;  // 2% de taxa
        if (valorComTaxa <= saldo) {
            saldo -= valorComTaxa;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}


