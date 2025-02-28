package org.example;

class CaminhaoRefrigerado extends Caminhao {
    int temperaturaMinima;  // Temperatura mínima para refrigeração

    public CaminhaoRefrigerado(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, int capacidadeCarga, int temperaturaMinima) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel, capacidadeCarga);
        this.temperaturaMinima = temperaturaMinima;
    }

    @Override
    public double calcularAutonomia() {
        return super.calcularAutonomia() * 0.9;  // Reduz a autonomia em 10% devido ao sistema de refrigeração
    }
}

