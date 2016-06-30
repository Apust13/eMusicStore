package com.apust.emusicstore.service.impl;

import com.apust.emusicstore.dao.ProductDao;
import com.apust.emusicstore.model.Product;
import com.apust.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GUN
 * on 31.05.2016.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void editProduct(Product product) {
        productDao.editProduct(product);

    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);

    }
}
