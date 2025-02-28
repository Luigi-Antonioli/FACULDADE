package org.example;

public class Main {
    public static void main(String[] args) {
        // Testando o Carro
        Carro carro = new Carro("Toyota", "Corolla", 2020, 5, "Gasolina", "Sedan");
        carro.exibirDetalhes();
        System.out.println("Autonomia: " + carro.calcularAutonomia() + " km\n");

        // Testando o Caminhão
        Caminhao caminhao = new Caminhao("Volvo", "FH", 2022, 2, "Diesel", 10);
        caminhao.exibirDetalhes();
        System.out.println("Autonomia: " + caminhao.calcularAutonomia() + " km\n");

        // Testando o Ônibus
        Onibus onibus = new Onibus("Mercedes", "O500", 2018, 40, "Diesel", 7);
        onibus.exibirDetalhes();
        System.out.println("Autonomia: " + onibus.calcularAutonomia() + " km\n");

        // Testando o Carro Elétrico
        CarroEletrico carroEletrico = new CarroEletrico("Tesla", "Model S", 2023, 5, "Elétrico", "SUV", 75);
        carroEletrico.exibirDetalhes();
        System.out.println("Autonomia: " + carroEletrico.calcularAutonomia() + " km\n");

        // Testando o Caminhão Refrigerado
        CaminhaoRefrigerado caminhaoRefrigerado = new CaminhaoRefrigerado("Scania", "R440", 2021, 2, "Diesel", 12, -10);
        caminhaoRefrigerado.exibirDetalhes();
        System.out.println("Autonomia: " + caminhaoRefrigerado.calcularAutonomia() + " km\n");
    }
}

