package org.example;

import java.util.LinkedList;

public class ExercicioLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> numeros = new LinkedList<>();

        // adicionando os numeros
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        //adicionando no inicio e no fim
        numeros.addFirst(5);
        numeros.addLast(60);

        System.out.println("Lista inicial dos numeros: " + numeros);

        //removendo o primeiro e o ultimo elemento
        numeros.removeFirst();
        numeros.removeLast();

        System.out.println("Lista Final dos numeros: " + numeros);
    }
}
