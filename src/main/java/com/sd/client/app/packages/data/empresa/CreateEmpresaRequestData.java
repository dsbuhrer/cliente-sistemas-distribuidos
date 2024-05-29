package com.sd.client.app.packages.data.empresa;

import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.Empresa;

public class CreateEmpresaRequestData extends PackageData {
    String name;
    String email;
    String password;
    String type;
    String token;

    public CreateEmpresaRequestData() {
    }

    public CreateEmpresaRequestData(Empresa empresa, String token) {
        name = empresa.getRazao();
        email = empresa.getEmail();
        password = empresa.getSenha();
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
