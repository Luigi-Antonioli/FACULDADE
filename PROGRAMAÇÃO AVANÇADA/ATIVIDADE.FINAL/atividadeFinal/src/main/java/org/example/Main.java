package org.example;

import org.example.pagamento.FormaPagamentoFactory;
import org.example.pagamento.Pagamento;
import org.example.repositorios.ProdutoRepositorio;
import org.example.repositorios.UsuarioRepositorio;
import org.example.repositorios.VendaRepositorio;
import org.example.entidades.Produto;
import org.example.entidades.Usuario;
import org.example.entidades.Venda;

import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:ecommerce.db";

        try (Connection connection = DriverManager.getConnection(url)) {
            UsuarioRepositorio usuarioRepo = new UsuarioRepositorio(connection);
            ProdutoRepositorio produtoRepo = new ProdutoRepositorio(connection);
            VendaRepositorio vendaRepo = new VendaRepositorio(connection);

            usuarioRepo.criarTabela();
            produtoRepo.criarTabela();
            vendaRepo.criarTabela();

            Scanner scanner = new Scanner(System.in);

            // 1. Buscar usuário por email
            System.out.print("Digite o Email do usuário: ");
            String email = scanner.nextLine();
            Optional<Usuario> usuarioOpt = usuarioRepo.buscarPorEmail(email);

            if (usuarioOpt.isEmpty()) {
                System.out.println("Usuário não encontrado.");
                return;
            }

            Usuario usuario = usuarioOpt.get();
            System.out.println("Usuário encontrado: " + usuario.getNome());

            // 2. Buscar produtos por ID
            System.out.print("Digite os IDs dos produtos (separados por vírgula): ");
            String[] ids = scanner.nextLine().split(",");

            List<Produto> produtosSelecionados = new ArrayList<>();
            for (String idStr : ids) {
                try {
                    int id = Integer.parseInt(idStr.trim());
                    Optional<Produto> produtoOpt = produtoRepo.buscarPorId(id);
                    if (produtoOpt.isPresent()) {
                        produtosSelecionados.add(produtoOpt.get());
                    } else {
                        System.out.println("Produto com ID " + id + " não encontrado.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ID inválido: " + idStr);
                }
            }

            if (produtosSelecionados.isEmpty()) {
                System.out.println("Nenhum produto válido selecionado. Venda cancelada.");
                return;
            }

            System.out.println("Produtos encontrados:");
            double total = 0;
            for (Produto p : produtosSelecionados) {
                System.out.println("- " + p.getNome() + " (R$ " + p.getPreco() + ")");
                total += p.getPreco();
            }

            // 3. Escolher forma de pagamento
            System.out.println("\nEscolha a forma de pagamento:");
            System.out.println("1 - Cartão de Crédito");
            System.out.println("2 - Boleto");
            System.out.println("3 - PIX");
            System.out.print("Opção: ");
            int opcaoPagamento = scanner.nextInt();
            scanner.nextLine();

            // Criar o pagamento através da fábrica
            Pagamento pagamento = FormaPagamentoFactory.criarPagamento(opcaoPagamento);
            if (pagamento == null) {
                System.out.println("Forma de pagamento inválida. Venda cancelada.");
                return;
            }

            System.out.println("Aguarde, efetuando pagamento...");
            String comprovante = pagamento.pagar(total);
            System.out.println("Pagamento confirmado com sucesso: " + comprovante);

            // 4. Registrar a venda
            Venda venda = new Venda(usuario, produtosSelecionados, total, pagamento.getTipo());
            vendaRepo.salvarVenda(venda);

            System.out.println("\nResumo da venda:");
            System.out.println("Cliente: " + usuario.getNome());
            for (Produto p : produtosSelecionados) {
                System.out.println("- " + p.getNome());
            }
            System.out.println("Valor total: R$ " + total);
            System.out.println("Pagamento: " + pagamento.getTipo());
            System.out.println("Venda registrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro no banco de dados: " + e.getMessage());
        }
    }
}
