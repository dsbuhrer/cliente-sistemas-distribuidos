package com.sd.client.app.packages;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.LinkedHashMap;

@JsonInclude(Include.NON_NULL)
public class BaseResponse<T> {

    private String operacao;

    private LinkedHashMap data;

    private boolean status;

    private String mensagem;

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public LinkedHashMap getData() {
        return data;
    }

    public void setData(LinkedHashMap data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public BaseResponse() {
        // Default constructor
    }
    public BaseResponse(String operacao, LinkedHashMap data, boolean status, String mensagem) {
        this.operacao = operacao;
        this.data = data;
        this.status = status;
        this.mensagem = mensagem;
    }

    ObjectMapper jackson = new ObjectMapper();
    public String toJson() throws JsonProcessingException {
        return jackson.writeValueAsString(this);
    }

    public static <T> BaseResponse fromJson(String json, Class<T> dataClass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean containsOnlyExpectedKeys = rootNode.has("operacao") && rootNode.has("status") && rootNode.has("mensagem");

        if (containsOnlyExpectedKeys) {
            JavaType responseType = objectMapper.getTypeFactory().constructParametricType(BaseResponse.class, dataClass);
            return objectMapper.readValue(json, responseType);
        } else {
            ObjectNode dataNode = objectMapper.createObjectNode();
            dataNode.setAll((ObjectNode) rootNode); // Copia todas as chaves do JSON para o campo "data"

            ObjectNode responseNode = objectMapper.createObjectNode();
            responseNode.put("operacao", rootNode.get("operacao").asText());
            responseNode.put("status", rootNode.get("status").asBoolean());
            if (rootNode.get("mensagem") != null){
                responseNode.put("mensagem", rootNode.get("mensagem").asText());
            }
            responseNode.set("data", dataNode);

            return objectMapper.treeToValue(responseNode, BaseResponse.class);
        }
    }



}
