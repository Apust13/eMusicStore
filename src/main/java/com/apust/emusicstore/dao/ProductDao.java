package com.apust.emusicstore.dao;

import com.apust.emusicstore.model.Product;

import java.util.List;

/**
 * Created by GUN
 * on 29.04.2016.
 */
public interface ProductDao {

    List<Product> getProductList();

    Product getProductById(int productId);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
