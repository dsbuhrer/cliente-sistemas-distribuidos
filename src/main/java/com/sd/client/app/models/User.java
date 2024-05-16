package com.sd.client.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {

    @JsonProperty
    private String uuid;

    @JsonProperty
    private String nome;

    @JsonProperty
    private String email;

    @JsonProperty
    private String senha;

    public User() {

    }

    public User(String uuid, String nome, String email, String senha) {
        this.uuid = uuid;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public User(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return this.uuid + "   " + this.nome;
    }
}
