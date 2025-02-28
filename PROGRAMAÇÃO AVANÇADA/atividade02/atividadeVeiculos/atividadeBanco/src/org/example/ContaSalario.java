package org.example;

class ContaSalario extends ContaCorrente {
    boolean saqueGratisFeito = false;

    public ContaSalario(String numeroConta, String titular, double saldo, double limiteChequeEspecial) {
        super(numeroConta, titular, saldo, limiteChequeEspecial);
    }

    @Override
    public void sacar(double valor) {
        if (!saqueGratisFeito) {
            super.sacar(valor);  // Saque gratuito
            saqueGratisFeito = true;
        } else {
            if (valor <= saldo + limiteChequeEspecial) {
                saldo -= valor + 5;  // Taxa de R$ 5
            } else {
                System.out.println("Saldo insuficiente!");
            }
        }
    }
}

