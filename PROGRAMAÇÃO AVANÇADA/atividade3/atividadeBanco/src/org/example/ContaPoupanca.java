package org.example;

class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}
