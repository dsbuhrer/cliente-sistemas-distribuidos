package com.sd.client.app.packages.data.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.User;

import java.util.UUID;

public class EditSelfUserRequestData extends PackageData {
    String id;
    String name;
    String email;
    String password;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String type;
    String token;

    public EditSelfUserRequestData() {
    }

    public EditSelfUserRequestData(User user, String token) {
        id = user.getUuid();
        name = user.getNome();
        email = user.getEmail();
        password = user.getSenha();
        this.token = token;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
