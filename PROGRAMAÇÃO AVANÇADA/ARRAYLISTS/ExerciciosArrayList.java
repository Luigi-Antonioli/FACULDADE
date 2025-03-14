package org.example;
import java.util.ArrayList;

public class ExerciciosArrayList {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();

        //adicionando os nomes
        nomes.add("Pipokinha");
        nomes.add("Valesca Popozuda");
        nomes.add("Ruiva de Marte");
        nomes.add("Mulher Melão");
        nomes.add("Mandy Gata");

        //exibindos os nomes
        System.out.println("Lista dos nomes: " + nomes);
    }
}
