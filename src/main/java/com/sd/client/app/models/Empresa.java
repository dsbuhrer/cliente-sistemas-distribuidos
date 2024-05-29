package com.sd.client.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Empresa {

    @JsonProperty
    private String uuid;

    @JsonProperty
    private String email;

    @JsonProperty
    private String senha;

    @JsonProperty
    private String razao;

    @JsonProperty
    private String cnpj;

    @JsonProperty
    private String description;

    @JsonProperty
    private String ramo;


    public Empresa() {

    }

    public Empresa(String uuid, String razao, String email, String senha , String cnpj, String description, String ramo) {
        this.uuid = uuid;
        this.email = email;
        this.senha = senha;
        this.razao = razao;
        this.cnpj = cnpj;
        this.description = description;
        this.ramo = ramo;
    }

    public Empresa(String razao, String email, String senha , String cnpj, String description, String ramo) {
        this.email = email;
        this.senha = senha;
        this.razao = razao;
        this.cnpj = cnpj;
        this.description = description;
        this.ramo = ramo;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
        return this.uuid + "   " + this.razao;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }
}
