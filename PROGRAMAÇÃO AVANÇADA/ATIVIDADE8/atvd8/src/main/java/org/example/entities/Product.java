package org.example.entities;

import java.util.UUID;

public class Product {
    private UUID uuid;
    private String description;
    private double hourlyRate;

    // Construtor com uuid (para uso ao buscar do banco)
    public Product(UUID uuid, String description, double hourlyRate) {
        this.uuid = uuid;
        this.description = description;
        this.hourlyRate = hourlyRate;
    }

    // Construtor sem uuid (para uso ao salvar no banco)
    public Product(String description, double hourlyRate) {
        this.uuid = UUID.randomUUID();
        this.description = description;
        this.hourlyRate = hourlyRate;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "Serviço{" +
                "uuid=" + uuid +
                ", descrição='" + description + '\'' +
                ", valor/hora=" + hourlyRate +
                '}';
    }
}
