package org.example;

class Carro extends Veiculo {
    String tipoCarro;  // Exemplo: Sedan, SUV, etc.

    public Carro(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, String tipoCarro) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
        this.tipoCarro = tipoCarro;
    }

    @Override
    public double calcularAutonomia() {
        return 50 * 12;  // 50 litros * 12 km/l
    }
}

