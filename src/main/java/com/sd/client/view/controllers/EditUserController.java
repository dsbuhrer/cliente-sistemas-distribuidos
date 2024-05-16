package com.sd.client.view.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sd.client.app.models.User;
import com.sd.client.app.repositories.UserRepository;
import com.sd.client.app.storage.LoggedUser;
import com.sd.client.view.Client;
import com.sd.client.view.validators.ValidationResponse;
import com.sd.client.view.validators.UserValidator;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditUserController extends BaseController implements Initializable {
    public TextField name_tf;
    public TextField email_tf;
    public TextField passwd_tf;
    public Button edit_btn;

    public User user;
    UserRepository userRepository = new UserRepository();


    public void edit(ActionEvent actionEvent) throws JsonProcessingException {
        ValidationResponse validationResponse;
        String name = name_tf.getText();
        String senha = passwd_tf.getText();

        User updated_usr = new User(user.getUuid(),name,LoggedUser.getLoggedEmail(),senha);
        Client.changeScreen(getStage(passwd_tf),userRepository.update(updated_usr));
    }

    public void back(){
        Client.changeScreen(getStage(passwd_tf),"menu/menu_admin.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        state_idProperty().addListener((ob,n,n1)->{
            try {
//                System.out.println(LoggedUser.getLoggedEmail());
//                System.out.println("fim initialize");
                user = userRepository.find(LoggedUser.getLoggedEmail());
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
//            System.out.println(user);
//            System.out.println("fim user");
            name_tf.setText(user.getNome());
            passwd_tf.setText(user.getSenha());
        });

    }
}
