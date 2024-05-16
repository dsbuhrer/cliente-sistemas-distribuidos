package com.sd.client.app.packages.data.user;

import com.sd.client.app.base.PackageData;

public class FindUserRequestData extends PackageData {
    private String token;
    private String user_id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public FindUserRequestData(String token, String user_id) {
        this.token = token;
        this.user_id = user_id;
    }

    public FindUserRequestData() {
    }
}

