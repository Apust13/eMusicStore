package com.apust.emusicstore.dao;

import com.apust.emusicstore.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GUN
 * on 18.04.2016.
 */
public class ProductDao {

    private List<Product> productList;

    public List<Product> getProductList() {
        Product product1 = new Product();

        product1.setProductId("1");
        product1.setProductName("Guitar");
        product1.setProductCategory("Instrument");
        product1.setProductDescription("This is classic fender strat guiter!");
        product1.setProductManufacturer("Fender");
        product1.setProductCondition("new");
        product1.setProductPrice(1200);
        product1.setProductStatus("Active");
        product1.setUnitInStock(11);

        Product product2 = new Product();

        product2.setProductId("2");
        product2.setProductName("Beatles");
        product2.setProductCategory("Record");
        product2.setProductDescription("This is classic mix of 20th century!");
        product2.setProductManufacturer("EMI");
        product2.setProductCondition("new");
        product2.setProductPrice(12);
        product2.setProductStatus("Active");
        product2.setUnitInStock(23);

        Product product3 = new Product();

        product3.setProductId("3");
        product3.setProductName("Speaker");
        product3.setProductCategory("Accessory");
        product3.setProductDescription("This is a Polk Shelf Speaker");
        product3.setProductManufacturer("Polk");
        product3.setProductCondition("new");
        product3.setProductPrice(355);
        product3.setProductStatus("Active");
        product3.setUnitInStock(3);

        productList = new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);



        return productList;
    }

    public Product getProductById(String productId)throws IOException{

        for(Product product : getProductList()){
            if(product.getProductId().equals(productId)){
                return product;
            }
        }
        throw new IOException("No product found!");

    }
}
