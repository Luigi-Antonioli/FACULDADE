package org.example;

public class Produto {
    int codigo;
    String Nome;
    double preco;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        Nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString(){
        return "Código: " + codigo + ", Nome: " + Nome + ", Preço: " + preco;
    }
}



