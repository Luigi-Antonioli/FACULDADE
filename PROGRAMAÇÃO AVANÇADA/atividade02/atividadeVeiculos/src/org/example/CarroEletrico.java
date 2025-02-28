package org.example;

class CarroEletrico extends Carro {
    int bateriaKWh;  // Quantidade de kWh da bateria

    public CarroEletrico(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, String tipoCarro, int bateriaKWh) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel, tipoCarro);
        this.bateriaKWh = bateriaKWh;
    }

    @Override
    public double calcularAutonomia() {
        return bateriaKWh * 5;  // 5 km por kWh
    }
}

