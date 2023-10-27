package com.example.crud.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Model {

    List<Product> products = new ArrayList<>();
    ObservableList<Product> observableProducts = FXCollections.observableList(products);

    public Model() {
        products.add(new Product("Milk","Dairy",15));
        products.add(new Product("Cheese","Dairy",99));
        products.add(new Product("Chocolate","Candy",40));
    }

    public ObservableList<Product> getObservableProducts() {
        return observableProducts;
    }
}
