package com.sd.client.app.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sd.client.app.base.BaseRepository;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.exceptions.ResponseErrorException;
import com.sd.client.app.packages.BaseResponse;
import com.sd.client.app.packages.data.login.LoginRequestData;
import com.sd.client.app.packages.data.login.LoginPackageData;
import com.sd.client.app.packages.data.logout.LogoutRequestData;
import com.sd.client.app.packages.BasePackage;
import com.sd.client.app.storage.LoggedUser;
import com.sd.client.view.validators.ValidationResponse;
import com.sd.client.view.validators.Validator;
import com.sd.client.view.validators.LoginValidator;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoginRepository extends BaseRepository {

    public LoginRepository() {
        super();
    }


    private boolean waitLoginResponse() {
        BaseResponse<LoginPackageData> response;
        String response_data;

        try {
            response_data = app.read();
            response = BaseResponse.fromJson(response_data, LoginPackageData.class);
            LinkedHashMap data = response.getData();

            LoggedUser.save(data.get("token").toString());
        } catch (IOException | ResponseErrorException e) {
            System.out.println(e.getMessage());
            return false;
//            "login/login.fxml"
        }
        return true;
//        "menu/menu_admin.fxml"
    }

    private boolean waitLogoutResponse() {
        try {
            app.read();
            LoggedUser.clear();
        } catch (IOException | ResponseErrorException e) {
            return false;
        }
        return true;
    }

    public String login(String email, String password) throws IOException {

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("email", email);
        dataMap.put("senha", password);

        BasePackage request = new BasePackage("loginCandidato", dataMap);
        String json = request.toJson();
        super.app.getOut().println(json);
        if (waitLoginResponse()){
            LoggedUser.saveEmail(dataMap.get("email").toString());
//            System.out.println(dataMap.get("email").toString() + "e-mail salvo");
            return "menu/menu_admin.fxml";
        }else {
            return "login/login.fxml";
        }

    }

    public boolean logout() throws JsonProcessingException {
        String token = LoggedUser.UUID();

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("token", token);

        BasePackage request = new BasePackage("logout", dataMap);
        super.app.getOut().println(request.toJson());
        return waitLogoutResponse();
    }

}
