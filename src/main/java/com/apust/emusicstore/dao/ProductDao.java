package com.apust.emusicstore.dao;

import com.apust.emusicstore.model.Product;

import java.util.List;

/**
 * Created by GUN
 * on 29.04.2016.
 */
public interface ProductDao {

    void addProduct(Product product);

    Product getProductById(int id);

    void editProduct(Product product);

    List<Product> getAllProducts();

    void deleteProduct(int id);
}
