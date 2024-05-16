package com.sd.client.app.packages.data.user;

import com.sd.client.app.base.PackageData;

public class GetUserRequestData extends PackageData {
    private String token;

    public GetUserRequestData(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
