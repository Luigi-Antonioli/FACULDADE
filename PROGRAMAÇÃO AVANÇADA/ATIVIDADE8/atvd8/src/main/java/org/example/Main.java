package org.example;

import org.example.entities.Product;
import org.example.repository.ProductRepository;
import org.example.repository.UserRepository;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database.sqlite";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                createTables(conn);
                ProductRepository productRepository = new ProductRepository(conn);
                UserRepository userRepository = new UserRepository(conn);

                runMenu(productRepository, userRepository);
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }

    private static void createTables(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            String createServicesTable =
                    "CREATE TABLE IF NOT EXISTS services (" +
                            "uuid TEXT PRIMARY KEY," +
                            "description TEXT NOT NULL," +
                            "hourly_rate REAL NOT NULL" +
                            ");";
            stmt.executeUpdate(createServicesTable);

            String createUsersTable =
                    "CREATE TABLE IF NOT EXISTS users (" +
                            "uuid TEXT PRIMARY KEY," +
                            "name TEXT NOT NULL," +
                            "email TEXT NOT NULL," +
                            "password TEXT NOT NULL," +
                            "role TEXT NOT NULL" +
                            ");";
            stmt.executeUpdate(createUsersTable);

            System.out.println("Tabelas criadas com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }

    private static void runMenu(ProductRepository productRepository, UserRepository userRepository) {
        try (Scanner scanner = new Scanner(System.in)) {
            int option;
            do {
                printMenu();
                option = scanner.nextInt();
                scanner.nextLine();  // Limpar o buffer

                switch (option) {
                    case 1:
                        cadastrarServico(scanner, productRepository);
                        break;
                    case 2:
                        listarServicos(productRepository);
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        break;
                    case 4:
                        limparServicos(productRepository);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (option != 3);
        } catch (Exception e) {
            System.out.println("Erro durante a execução: " + e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1 - Cadastrar Serviço");
        System.out.println("2 - Listar Serviços");
        System.out.println("3 - Sair");
        System.out.println("4 - Limpar todos os serviços");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarServico(Scanner scanner, ProductRepository productRepository) {
        System.out.print("Descrição do serviço: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor por hora: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();  // Limpar o buffer

        Product novoServico = new Product(descricao, valor);
        productRepository.save(novoServico);
        System.out.println("Serviço cadastrado com sucesso.");
    }

    private static void listarServicos(ProductRepository productRepository) {
        List<Product> servicos = productRepository.findAll();
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço encontrado.");
        } else {
            // Substituindo forEach por um loop tradicional
            for (Product servico : servicos) {
                System.out.println(servico);
            }
        }
    }

    private static void limparServicos(ProductRepository productRepository) {
        try {
            productRepository.deleteAll();
            System.out.println("Todos os serviços foram removidos com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao limpar os serviços: " + e.getMessage());
        }
    }
}
