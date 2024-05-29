package com.sd.client.view.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sd.client.app.models.Empresa;
import com.sd.client.app.repositories.EmpresaRepository;
import com.sd.client.view.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.cell.ComboBoxListCell;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;


public class ListEmpresaController extends BaseController implements Initializable {

    public List<Empresa> empresas_ll = new LinkedList<>();
    public EmpresaRepository empresaRepository = new EmpresaRepository();
    public SelectionModel<Empresa> selected_empresa_model;
    public Empresa selected_empresa;
    public ObservableList<Empresa> empresas = FXCollections.observableList(empresas_ll);
    public ListView<Empresa> empresa_list;
    public Button refreshButton;
    public Button edit_btn;
    public Button remove_btn;

    public void refresh() throws JsonProcessingException {
        empresas.setAll(empresaRepository.get());
        empresa_list.setItems(empresas);
        empresa_list.refresh();
    }

    public void removeEmpresa(ActionEvent actionEvent) throws JsonProcessingException {
        empresaRepository.destroy(selected_empresa);
        refresh();
    }

    public void editEmpresa(ActionEvent actionEvent) {
        Client.changeScreen(getStage(remove_btn),"empresa/edit_empresa.fxml",selected_empresa.getUuid());
    }

    public void back(){
        Client.changeScreen(getStage(remove_btn),"menu/menu_admin.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        empresa_list.setCellFactory(ComboBoxListCell.forListView(empresas));

        selected_empresa_model = empresa_list.getSelectionModel();
        selected_empresa_model.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Handle the selection change here
            selected_empresa = newValue;
            remove_btn.setDisable(false);
            edit_btn.setDisable(false);
        });
        try {
            refresh();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
