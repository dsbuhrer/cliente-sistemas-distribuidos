package com.sd.client.view.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sd.client.app.repositories.LoginRepository;
import com.sd.client.view.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController extends BaseController {
    @FXML
    public TextField email_tf;
    @FXML
    public TextField passwd_tf;
    public Button login_btn;
    public Button add_usr_btn;
    public Button add_empresa_btn;
    public Button login_empresa_btn;
    public Button login_candidato_btn;
    LoginRepository login_repository = new LoginRepository();


    public LoginController() {
    }

    @FXML
    protected void login() throws IOException {
        String email = email_tf.getText();
        String password = passwd_tf.getText();
        String next_screen = login_repository.login(email,password);
        Client.changeScreen(getStage(login_btn),next_screen);
    }
    @FXML
    protected void loginEmpresa() throws IOException {
        String email = email_tf.getText();
        String password = passwd_tf.getText();
        String next_screen = login_repository.loginEmpresa(email,password);
        Client.changeScreen(getStage(login_btn),next_screen);
    }

    public void createUser(ActionEvent actionEvent) {
        Client.changeScreen(getStage(add_usr_btn),"user/create_user.fxml");
    }

    public void createEmpresa(ActionEvent actionEvent) {
        Client.changeScreen(getStage(add_empresa_btn),"empresa/create_user.fxml");
    }

    public void loginEmpresaScreen(ActionEvent actionEvent) {
        Client.changeScreen(getStage(login_empresa_btn),"loginEmpresa/login.fxml");
    }

    public void loginCandidato(ActionEvent actionEvent) {
        Client.changeScreen(getStage(login_candidato_btn),"login/login.fxml");
    }

}