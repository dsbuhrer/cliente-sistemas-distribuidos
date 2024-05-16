//package com.sd.client.view.controllers;
//
//import com.sd.client.view.Client;
//import javafx.beans.property.ReadOnlyIntegerWrapper;
//import javafx.beans.property.ReadOnlyStringWrapper;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class GenerateRouteController extends BaseController implements Initializable {
//
//    public Button generate_btn;
//    public TableView route_tbl;
//
//
//    public void generate(ActionEvent actionEvent) {
//
//        route_tbl.setItems(FXCollections.observableList(segmentRepository.requestRoute(origin_cmb.getValue(),destiny_cmb.getValue())));
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        points = FXCollections.observableList(pointRepository.get());
//        origin_cmb.setItems(points);
//        destiny_cmb.setItems(points);
//        index_cell.setCellValueFactory(cellData ->new ReadOnlyIntegerWrapper(route_tbl.getItems().indexOf(cellData.getValue()) + 1).getReadOnlyProperty().asObject());
//        origin_cell.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getOrigin().getName()));
//        destin_cell.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getDestination().getName()));
//        distance_cell.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(cellData.getValue().getDistance())));
//        direction_cell.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getDirection()));
//        observation_cell.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getObservation()));
//    }
//
//    public void back(ActionEvent actionEvent) {
//        Client.changeScreen(getStage(route_tbl),"menu/menu_user.fxml");
//    }
//}
