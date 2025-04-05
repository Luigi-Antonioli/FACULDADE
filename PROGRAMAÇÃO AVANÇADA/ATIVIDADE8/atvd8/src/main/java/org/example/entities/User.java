package org.example.entities;

import java.util.UUID;

public class User {
    private UUID uuid;
    private String name;
    private String email;
    private String password;
    private String role;

    public User(UUID uuid, String name, String email, String password, String role) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String name, String email, String password, String role) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Usuário{" +
                "uuid=" + uuid +
                ", nome='" + name + '\'' +
                ", email='" + email + '\'' +
                ", perfil='" + role + '\'' +
                '}';
    }
}
