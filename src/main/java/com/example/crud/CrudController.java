package com.example.crud;

import com.example.crud.model.Model;
import com.example.crud.model.Product;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CrudController {

    public TableView<Product> tableView;
    public TableColumn<Product, String> nameColumn;
    public TableColumn<Product, Integer> priceColumn;

    public TextField productName;
    public TextField productPrice;
    public TextField productCategory;
    public Button deleteButton;

    Model model = new Model();

    public void initialize() {
        tableView.setItems(model.getObservableProducts());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        model.selectedProductProperty().bind(tableView.getSelectionModel().selectedItemProperty());
        deleteButton.disableProperty().bind( Bindings.isNull(model.selectedProductProperty()) );

    }


    public void newProduct(ActionEvent actionEvent) {


    }

    public void updateProduct(ActionEvent actionEvent) {

    }

    public void deleteProduct(ActionEvent actionEvent) {
        model.deleteSelectedProduct();
    }
}
