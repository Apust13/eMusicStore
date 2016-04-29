package com.apust.emusicstore.controller;

import com.apust.emusicstore.dao.ProductDao;
import com.apust.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

/**
 * Created by GUN
 * on 14.04.2016.
 */

@Controller
public class HomeController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products",products);
        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException{
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);
        return "viewProduct";
    }

    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/admin/productInventary")
    public String productInventary(Model model){
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return "productInventary";
    }

    @RequestMapping("/admin/productInventary/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductName("JazzBass");
        product.setProductPrice(1500);
        product.setProductStatus("active");
        product.setUnitInStock(2);
        product.setProductDescription("This is the legendary bass guitar with amaizing sound!");

        model.addAttribute("product", product);
        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventary/addProduct", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product){
        productDao.addProduct(product);
        return "redirect:/admin/productInventary";

    }


}