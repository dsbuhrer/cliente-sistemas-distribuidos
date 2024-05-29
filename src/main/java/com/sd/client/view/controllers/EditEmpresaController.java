package com.sd.client.view.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sd.client.app.models.Empresa;
import com.sd.client.app.repositories.EmpresaRepository;
import com.sd.client.app.storage.LoggedEmpresa;
import com.sd.client.view.Client;
import com.sd.client.view.validators.ValidationResponse;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditEmpresaController extends BaseController implements Initializable {
    public TextField razao_tf;
    public TextField email_tf;
    public TextField passwd_tf;
    public TextField cnpj_tf;
    public TextField descricao_tf;
    public TextField ramo_tf;
    public Button edit_btn;

    public Empresa empresa;
    EmpresaRepository empresaRepository = new EmpresaRepository();


    public void edit(ActionEvent actionEvent) throws JsonProcessingException {
        String razao = razao_tf.getText();
        String senha = passwd_tf.getText();
        String cnpj = cnpj_tf.getText();
        String descricao = descricao_tf.getText();
        String ramo = ramo_tf.getText();

        Empresa updated_usr = new Empresa(empresa.getUuid(),razao, empresa.getEmail(), senha,cnpj,descricao,ramo);
        Client.changeScreen(getStage(passwd_tf),empresaRepository.update(updated_usr));
    }

    public void back(){
        Client.changeScreen(getStage(passwd_tf),"menu/menu_admin.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        state_idProperty().addListener((ob,n,n1)->{
            try {
                empresa = empresaRepository.find(LoggedEmpresa.getLoggedEmail());
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            razao_tf.setText(empresa.getRazao());
            if (email_tf != null){
                email_tf.setText(empresa.getEmail());
            }
            passwd_tf.setText(empresa.getSenha());
            cnpj_tf.setText(empresa.getCnpj());
            descricao_tf.setText(empresa.getDescription());
            ramo_tf.setText(empresa.getRamo());
        });

    }
}
