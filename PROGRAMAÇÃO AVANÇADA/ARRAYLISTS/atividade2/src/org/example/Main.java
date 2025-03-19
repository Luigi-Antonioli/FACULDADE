package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        int opcao;

        do{
            System.out.println("\n---Menu---");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Buscar produto por código");
            System.out.println("3 - Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    // cadastrando produto
                    System.out.println("\nOpção de cadastro selecionada.");
                    System.out.println("Digite o código do produto: ");
                    int codigo = scanner.nextInt();

                    // inserindo o nome do produto
                    System.out.println("\nInsira o nome do produto: ");
                    String Nome = scanner.next();

                    // inserindo o preço do produto
                    System.out.println("\nQual o preço do produto: ");
                    double preco = scanner.nextDouble();

                    // criando o novo produto adicionado na Arraylist
                    produtos.add(new Produto(codigo,Nome,preco));
                    System.out.println("Produto " + codigo + " cadastrado.");
                break;

                case 2:
                    // buscando o produto
                    System.out.println("Opção de busca selecionada.");
                    System.out.println("Digite o código do produto que deseja buscar: ");
                    int codigoBusca = scanner.nextInt();

                    Produto produtoEncontrado = null;
                    // procurando o produto no arrayList
                    for (Produto p : produtos){
                        if(p.codigo == codigoBusca){
                            produtoEncontrado = p;
                            break;
                        }
                    }
                    // caso o produto seja encontrado
                    if (produtoEncontrado != null){
                        System.out.println("Produto encontrado: "+ produtoEncontrado);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
        scanner.close();
    }
}
