package com.sd.client.app.packages.data.empresa;

import com.sd.client.app.base.PackageData;

public class FindSelfEmpresaRequestData extends PackageData {
    private String token;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public FindSelfEmpresaRequestData(String token) {
        this.token = token;
    }

    public FindSelfEmpresaRequestData() {
    }
}

