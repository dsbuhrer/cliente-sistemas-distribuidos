package com.sd.client.view.controllers;

import com.sd.client.app.App;
import javafx.beans.property.*;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BaseController {

    App app;

    private StringProperty state_id = new SimpleStringProperty("");

    public String getState_id() {
        return state_id.get();
    }

    public StringProperty state_idProperty() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id.set(state_id);
    }

    public Stage getStage(Node element){
        return (Stage) element.getScene().getWindow();
    }
    public BaseController() {
    }

}
