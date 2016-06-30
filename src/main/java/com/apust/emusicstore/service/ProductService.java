package com.apust.emusicstore.service;

import com.apust.emusicstore.model.Product;

import java.util.List;

/**
 * Created by GUN
 * on 31.05.2016.
 */
public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int productId);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);


}
