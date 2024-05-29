package com.sd.client.app.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sd.client.app.base.BaseRepository;
import com.sd.client.app.exceptions.ResponseErrorException;
import com.sd.client.app.models.Empresa;
import com.sd.client.app.packages.BasePackage;
import com.sd.client.app.packages.BaseResponse;
import com.sd.client.app.packages.data.empresa.FindEmpresaPackageData;
import com.sd.client.app.packages.data.empresa.GetEmpresaPackageData;
import com.sd.client.app.storage.LoggedEmpresa;
import com.sd.client.app.storage.LoggedUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class EmpresaRepository extends BaseRepository {
    public EmpresaRepository() {
        super();
    }

    private String waitCreateResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            return "empresa/create_user.fxml";
        }
        return "login/login.fxml";
    }

    private String waitUpdateResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            return "empresa/edit_user.fxml";
        }
        return "menu/menu_admin.fxml";
    }


    private ArrayList<Empresa> waitGetResponse() {
        BaseResponse<GetEmpresaPackageData> response;
        String response_data;
        try {
            response_data = app.read();
            response = BaseResponse.fromJson(response_data, GetEmpresaPackageData.class);
//            System.out.println("response");
//            System.out.println(response);
            ArrayList<Empresa> empresasList = new ArrayList<>();

            empresasList.add(new Empresa("das","dasda","dasda","dasda","dasda","dasda"));
            return empresasList;
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

    public String create(Empresa new_empre) throws JsonProcessingException {
        Map<String, Object> dataMap = new HashMap<>();
//        System.out.println(new_empre.getEmail());
        dataMap.put("razaoSocial", new_empre.getRazao());
        dataMap.put("email", new_empre.getEmail());
        dataMap.put("senha", new_empre.getSenha());
        dataMap.put("cnpj", new_empre.getCnpj());
        dataMap.put("descricao", new_empre.getDescription());
        dataMap.put("ramo", new_empre.getRamo());

        BasePackage request = new BasePackage("cadastrarEmpresa", dataMap);
        String json = request.toJson();
        app.getOut().println(json);
        return waitCreateResponse();
    }

    public String update(Empresa updated_empre) throws JsonProcessingException {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("razaoSocial", updated_empre.getRazao());
        dataMap.put("email", updated_empre.getEmail());
        dataMap.put("senha", updated_empre.getSenha());
        dataMap.put("cnpj", updated_empre.getCnpj());
        dataMap.put("descricao", updated_empre.getDescription());
        dataMap.put("ramo", updated_empre.getRamo());

        BasePackage request = new BasePackage("atualizarEmpresa", dataMap);
        String json = request.toJson();
        app.getOut().println(json);
        return waitUpdateResponse();
    }

    public ArrayList<Empresa> get() throws JsonProcessingException {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("token", LoggedEmpresa.UUID());

        BasePackage request = new BasePackage("listarEmpresas", dataMap);
        String json = request.toJson();
        app.getOut().println(json);
        return waitGetResponse();
    }

    public void destroy(Empresa empresa) throws JsonProcessingException {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("email", empresa.getEmail());

        BasePackage request = new BasePackage("apagarEmpresa", dataMap);
        String json = request.toJson();
        app.getOut().println(json);
        waitDestroyResponse();
    }

    public Empresa find(String email) throws JsonProcessingException {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("email", email);

        BasePackage request = new BasePackage("visualizarEmpresa", dataMap);
        String json = request.toJson();
        app.getOut().println(json);
        return waitFindResponse();
    }

    private Empresa waitFindResponse() {
        BaseResponse<FindEmpresaPackageData>    response;
        String response_data;
        try {
            response_data = app.read();
            response = BaseResponse.fromJson(response_data, FindEmpresaPackageData.class);
            LinkedHashMap data = response.getData();
//            System.out.println("response find");
//            System.out.println(data);
//            System.out.println(response);
//            System.out.println(response_data);
            Empresa empresa = new Empresa(data.get("razaoSocial").toString(),LoggedEmpresa.getLoggedEmail(),data.get("senha").toString(),data.get("cnpj").toString(),data.get("descricao").toString(),data.get("ramo").toString());
            return empresa;
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
            return new Empresa();
        }
    }

    public boolean destroySelf(){
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("email", LoggedEmpresa.getLoggedEmail());

        BasePackage request = new BasePackage("apagarEmpresa",dataMap);
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
