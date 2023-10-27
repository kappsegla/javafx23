package com.example.crud;

import com.example.crud.model.Model;
import com.example.crud.model.Product;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

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

        model.selectedProductProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue<? extends Product> observable, Product oldValue, Product newValue) {
                if( oldValue != null) {
                    productName.textProperty().unbindBidirectional(oldValue.nameProperty());
                    productPrice.textProperty().unbindBidirectional(oldValue.priceProperty());
                    productPrice.textProperty().unbindBidirectional(oldValue.categoryProperty());
                }
                productName.textProperty().bindBidirectional(newValue.nameProperty());
                Bindings.bindBidirectional(productPrice.textProperty(), newValue.priceProperty(), new NumberStringConverter());
                productCategory.textProperty().bindBidirectional(newValue.categoryProperty());
            }
        });



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
