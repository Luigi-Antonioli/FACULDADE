package org.example.repositorios;

import org.example.entidades.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UsuarioRepositorio {

    private final Connection connection;

    public UsuarioRepositorio(Connection connection) {
        this.connection = connection;
    }

    public void criarTabela() {
        String query = "CREATE TABLE IF NOT EXISTS users (" +
                "uuid TEXT PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "email TEXT NOT NULL UNIQUE" +
                ")";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.executeUpdate();
            System.out.println("Tabela de usuários criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela de usuários: " + e.getMessage());
        }
    }


    public void save(Usuario usuario) {
        String sql = "INSERT INTO usuarios (uuid, nome, email) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getUuid().toString());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario(
                        UUID.fromString(rs.getString("uuid")),
                        rs.getString("nome"),
                        rs.getString("email")
                );
                return Optional.of(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário: " + e.getMessage());
        }
        return Optional.empty();
    }

    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuarios.add(new Usuario(
                        UUID.fromString(rs.getString("uuid")),
                        rs.getString("nome"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar usuários: " + e.getMessage());
        }
        return usuarios;
    }
}

