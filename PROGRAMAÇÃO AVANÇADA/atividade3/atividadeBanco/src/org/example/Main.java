package org.example;

public class Main {
    public static void main(String[] args) {
        // Criando e testando uma ContaCorrente
        ContaCorrente contaCorrente = new ContaCorrente("12345", "João", 1000, 500);
        contaCorrente.exibirInformacoes();
        contaCorrente.sacar(1200);  // Usa o cheque especial
        contaCorrente.sacar(2000);  // Não tem saldo suficiente

        // Criando e testando uma ContaPoupanca
        ContaPoupanca contaPoupanca = new ContaPoupanca("67890", "Maria", 1500);
        contaPoupanca.exibirInformacoes();
        contaPoupanca.sacar(1000);  // Saque permitido
        contaPoupanca.sacar(6000);  // Não tem saldo suficiente

        // Criando e testando uma ContaInvestimento
        ContaInvestimento contaInvestimento = new ContaInvestimento("11223", "Carlos", 5000);
        contaInvestimento.exibirInformacoes();
        contaInvestimento.sacar(1000);  // Saque com taxa de 2%

        // Criando e testando uma ContaSalario
        ContaSalario contaSalario = new ContaSalario("44556", "Ana", 2000, 1000);
        contaSalario.exibirInformacoes();
        contaSalario.sacar(500);  // Saque gratuito
        contaSalario.sacar(200);  // Saque com taxa de R$ 5

        // Criando e testando uma ContaInvestimentoAltoRisco
        ContaInvestimentoAltoRisco contaInvestimentoAltoRisco = new ContaInvestimentoAltoRisco("99887", "Pedro", 15000);
        contaInvestimentoAltoRisco.exibirInformacoes();
        contaInvestimentoAltoRisco.sacar(2000);  // Saque com taxa de 5%
        contaInvestimentoAltoRisco.sacar(8000);  // Não tem saldo suficiente
    }
}

