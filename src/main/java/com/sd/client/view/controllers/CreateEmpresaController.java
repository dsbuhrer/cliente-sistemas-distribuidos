package com.sd.client.view.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sd.client.app.models.Empresa;
import com.sd.client.app.repositories.EmpresaRepository;
import com.sd.client.view.Client;
import com.sd.client.view.validators.ValidationResponse;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateEmpresaController extends BaseController {
    public TextField name_tf;
    public TextField email_tf;
    public TextField razao_tf;
    public TextField cnpj_tf;
    public TextField description_tf;
    public TextField ramo_tf;
    public TextField passwd_tf;
    public Button create_btn;

    EmpresaRepository empresaRepository = new EmpresaRepository();


    public void create(ActionEvent actionEvent) throws JsonProcessingException {
        ValidationResponse validationResponse;
        String email = email_tf.getText();
        String password = passwd_tf.getText();
        String razao = razao_tf.getText();
        String cnpj = cnpj_tf.getText();
        String description = description_tf.getText();
        String ramo = ramo_tf.getText();

        Empresa new_empr = new Empresa(razao,email,password,cnpj,description,ramo);
        Client.changeScreen(getStage(create_btn),empresaRepository.create(new_empr));
    }

    public void back(){
        Client.changeScreen(getStage(create_btn),"login/login.fxml");
    }
}
