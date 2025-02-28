package org.example;

abstract class Veiculo {
    String marca;
    String modelo;
    int ano;
    int capacidadePassageiros;
    String combustivel;

    // Construtor
    public Veiculo(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.capacidadePassageiros = capacidadePassageiros;
        this.combustivel = combustivel;
    }

    // Método abstrato para calcular autonomia
    public abstract double calcularAutonomia();

    // Método para exibir os detalhes do veículo
    public void exibirDetalhes() {
        System.out.println(marca + " " + modelo + " (" + ano + ")");
        System.out.println("Passageiros: " + capacidadePassageiros + " | Combustível: " + combustivel);
    }
}

