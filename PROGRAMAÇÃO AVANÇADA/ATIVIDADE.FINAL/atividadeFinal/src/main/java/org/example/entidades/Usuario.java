package org.example.entidades;

import java.util.UUID;

public class Usuario {
    private UUID uuid;
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.uuid = UUID.randomUUID();  // Gerar UUID automaticamente
        this.nome = nome;
        this.email = email;
    }

    public Usuario(UUID uuid, String nome, String email) {
        this.uuid = uuid;
        this.nome = nome;
        this.email = email;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "uuid=" + uuid +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

