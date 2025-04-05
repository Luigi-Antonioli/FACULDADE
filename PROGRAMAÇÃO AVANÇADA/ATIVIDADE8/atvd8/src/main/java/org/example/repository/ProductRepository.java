package org.example.repository;

import org.example.entities.Product;

import java.sql.*;
import java.util.*;

public class ProductRepository implements EntityRepository<Product> {

    private final Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Product service) {
        String query = "INSERT INTO services (uuid, description, hourly_rate) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, service.getUuid().toString());
            stmt.setString(2, service.getDescription());
            stmt.setDouble(3, service.getHourlyRate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar serviço", e);
        }
    }

    @Override
    public Optional<Product> findById(UUID id) {
        String query = "SELECT * FROM services WHERE uuid = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Product service = new Product(
                        UUID.fromString(rs.getString("uuid")),
                        rs.getString("description"),
                        rs.getDouble("hourly_rate")
                );
                return Optional.of(service);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar serviço por ID", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        List<Product> services = new ArrayList<>();
        String query = "SELECT * FROM services";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product service = new Product(
                        UUID.fromString(rs.getString("uuid")),
                        rs.getString("description"),
                        rs.getDouble("hourly_rate")
                );
                services.add(service);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar serviços", e);
        }
        return services;
    }

    @Override
    public void deleteById(UUID id) {
        String query = "DELETE FROM services WHERE uuid = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id.toString());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar serviço", e);
        }
    }

    public void deleteAll() throws SQLException {
        String query = "DELETE FROM services";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao remover todos os serviços", e);
        }
    }
}
