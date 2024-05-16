package com.sd.client.app.packages.data.user;

import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.User;

public class CreateUserRequestData extends PackageData {
    String name;
    String email;
    String password;
    String type;
    String token;

    public CreateUserRequestData() {
    }

    public CreateUserRequestData(User user, String token) {
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
}
