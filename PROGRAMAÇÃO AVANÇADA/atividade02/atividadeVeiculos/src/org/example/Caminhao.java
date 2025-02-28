package org.example;

class Caminhao extends Veiculo {
    int capacidadeCarga;  // Toneladas

    public Caminhao(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, int capacidadeCarga) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public double calcularAutonomia() {
        double consumo = 6;  // km/l
        consumo -= Math.min(capacidadeCarga * 0.01, 0.25);  // Redução do consumo com base na carga
        return 300 * consumo;  // 300 litros de combustível
    }
}

