package com.sd.client.app.packages.data.user;

import com.sd.client.app.base.PackageData;

public class DeleteSelfUserRequestData extends PackageData {
    String token;

    String email;

    String password;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public DeleteSelfUserRequestData() {
    }

    public DeleteSelfUserRequestData(String token, String email, String password) {
        this.token = token;
        this.email = email;
        this.password = password;
    }
}
