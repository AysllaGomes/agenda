package com.example.agenda.model;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class Aluno implements Serializable {

    private int id = 0;
    private String nome;
    private String telefone;
    private String email;

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Aluno() {}

    public int getId() { return id; }

    public String getNome() { return nome; }

    public String getTelefone() { return telefone; }

    public String getEmail() { return email; }

    public void setId(int id) { this.id = id; }

    public void setNome(String nome) { this.nome = nome; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public void setEmail(String email) { this.email = email; }

    @NonNull
    @Override
    public String toString() {
        return nome + " - " + telefone;
    }

    public boolean idValido() {
        return id > 0;
    }
}
