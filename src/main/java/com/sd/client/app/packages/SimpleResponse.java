package com.sd.client.app.packages;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sd.client.app.base.PackageData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class SimpleResponse {

    private static final Logger logger = LogManager.getLogger(SimpleResponse.class);

    private String operacao;
    @JsonIgnore
    private PackageData data;
    private Integer status;

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private String mensagem;
    private String  token;
    private String  senha;
    private String  nome;

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Integer isStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public SimpleResponse() {
    }

    public SimpleResponse(String operacao, Integer status, String mensagem) {
        this.operacao = operacao;
        this.status = status;
        this.mensagem = mensagem;
    }

    public PackageData getData() {
        return data;
    }

    public void setData(PackageData data) {
        this.data = data;
    }

    ObjectMapper jackson = new ObjectMapper();
    public String toJson() throws JsonProcessingException {
        return jackson.writeValueAsString(this);
    }

    public static <T> T fromJson(String json, Class<T> generic_response) throws JsonProcessingException {
        ObjectMapper jackson = new ObjectMapper();
        logger.info("Recebido: "+json);
        return jackson.readValue(json, generic_response);
    }

    public boolean isError(SimpleResponse response) {
        if (response.status == 200 || response.status == 204 || response.status == 201) {
            return false;
        } else {
            return true;
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
