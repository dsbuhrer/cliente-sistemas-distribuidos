package com.sd.client.app.packages;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.sd.client.app.base.PackageData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasePackage {

    private static final Logger logger = LogManager.getLogger(BasePackage.class);

    private String operacao;
    private Map<String, Object> data = new HashMap<>();

    private final ObjectMapper jackson = new ObjectMapper();

    @JsonAnyGetter
    public Map<String, Object> getData() {
        return data;
    }

    public BasePackage(String operacao, Map<String, Object> data) {
        this.operacao = operacao;
        this.data = data;
    }


    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }


    @JsonAnySetter
    public void setData(String key, Object value) {
        data.put(key, value);
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        logger.info("Enviado: " + objectMapper.writeValueAsString(this));
        return objectMapper.writeValueAsString(this);
    }

    public static <T> T fromJson(String json, Class<T> generic_response) throws JsonProcessingException {
        ObjectMapper jackson = new ObjectMapper();
        return jackson.readValue(json, generic_response);
    }

    public static BaseResponse simpleFromJson(String json) {
        ObjectMapper jackson = new ObjectMapper();
        jackson.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return jackson.readValue(json, BaseResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        try {
            return this.toJson();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
