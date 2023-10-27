package com.example.crud.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Model {

    List<Product> products = new ArrayList<>();
    ObservableList<Product> observableProducts = FXCollections.observableList(products);

    ObjectProperty<Product> selectedProduct = new SimpleObjectProperty<>();

    public Model() {
        products.add(new Product("Milk","Dairy",15));
        products.add(new Product("Cheese","Dairy",99));
        products.add(new Product("Chocolate","Candy",40));
    }

    public ObservableList<Product> getObservableProducts() {
        return observableProducts;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Model setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public Model setObservableProducts(ObservableList<Product> observableProducts) {
        this.observableProducts = observableProducts;
        return this;
    }

    public Product getSelectedProduct() {
        return selectedProduct.get();
    }

    public ObjectProperty<Product> selectedProductProperty() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct.set(selectedProduct);
    }

    public void deleteSelectedProduct() {
        //If connected to database, delete from database then reload objects from database to list.
        observableProducts.remove(selectedProduct.get());
    }
}
