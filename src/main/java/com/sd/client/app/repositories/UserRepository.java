package com.sd.client.app.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sd.client.app.base.BaseRepository;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.exceptions.ResponseErrorException;
import com.sd.client.app.packages.BaseResponse;
import com.sd.client.app.packages.data.login.LoginPackageData;
import com.sd.client.app.packages.data.user.*;
import com.sd.client.app.models.User;
import com.sd.client.app.packages.BasePackage;
import com.sd.client.app.storage.LoggedUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserRepository extends BaseRepository {
    public UserRepository() {
        super();
    }

    private String waitCreateResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            return "user/create_user.fxml";
        }
        return "login/login.fxml";
    }

    private String waitUpdateResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            return "user/edit_user.fxml";
        }
        return "menu/menu_admin.fxml";
    }


    private ArrayList<User> waitGetResponse() {
        BaseResponse<GetUserPackageData> response;
        String response_data;
        try {
            response_data = app.read();
            response = BaseResponse.fromJson(response_data, GetUserPackageData.class);
//            System.out.println("response");
//            System.out.println(response);
            ArrayList<User> usersList = new ArrayList<>();

            usersList.add(new User("dsa","das","dasda"));
            return usersList;
            //testes de get
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
            return new ArrayList<>();
        }
    }

    private void waitDestroyResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
        }
    }

    public String create(User new_usr) throws JsonProcessingException {
        Map<String, Object> dataMap = new HashMap<>();
//        System.out.println(new_usr.getEmail());
        dataMap.put("nome", new_usr.getNome());
        dataMap.put("email", new_usr.getEmail());
        dataMap.put("senha", new_usr.getSenha());

        BasePackage request = new BasePackage("cadastrarCandidato", dataMap);
        String json = request.toJson();
        app.getOut().println(json);
        return waitCreateResponse();
    }

    public String update(User updated_usr) throws JsonProcessingException {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("nome", updated_usr.getNome());
        dataMap.put("email", updated_usr.getEmail());
        dataMap.put("senha", updated_usr.getSenha());

        BasePackage request = new BasePackage("atualizarCandidato", dataMap);
        String json = request.toJson();
        app.getOut().println(json);
        return waitUpdateResponse();
    }

    public ArrayList<User> get() throws JsonProcessingException {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("token", LoggedUser.UUID());

        BasePackage request = new BasePackage("listarCandidatos", dataMap);
        String json = request.toJson();
        app.getOut().println(json);
        return waitGetResponse();
    }

    public void destroy(User user) throws JsonProcessingException {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("email", user.getEmail());

        BasePackage request = new BasePackage("apagarCandidato", dataMap);
        String json = request.toJson();
        app.getOut().println(json);
        waitDestroyResponse();
    }

    public User find(String email) throws JsonProcessingException {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("email", email);

        BasePackage request = new BasePackage("visualizarCandidato", dataMap);
        String json = request.toJson();
        app.getOut().println(json);
        return waitFindResponse();
    }

    private User waitFindResponse() {
        BaseResponse<FindUserPackageData>    response;
        String response_data;
        try {
            response_data = app.read();
            response = BaseResponse.fromJson(response_data, FindUserPackageData.class);
            LinkedHashMap data = response.getData();
//            System.out.println("response find");
//            System.out.println(data);
//            System.out.println(response);
//            System.out.println(response_data);
            User user = new User(data.get("nome").toString(),LoggedUser.getLoggedEmail(),data.get("senha").toString());
            return user;
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
            return new User();
        }
    }

    public boolean destroySelf(){
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("email", LoggedUser.getLoggedEmail());

        BasePackage request = new BasePackage("apagarCandidato",dataMap);
        String json = request.toString();
        app.getOut().println(json);
        return waitDestroySelfResponse();
    }

    private boolean waitDestroySelfResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
            return false;
        }
        return true;
    }


}
