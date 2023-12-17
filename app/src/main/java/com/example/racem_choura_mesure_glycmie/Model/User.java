package com.example.racem_choura_mesure_glycmie.Model;

public class User {
    private String Username;
    private String password;

    public User(String Username, String password) {
        this.Username = Username;
        this.password = password;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }
}
