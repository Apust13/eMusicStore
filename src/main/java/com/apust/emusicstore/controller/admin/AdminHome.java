package com.apust.emusicstore.controller.admin;

import com.apust.emusicstore.model.Customer;
import com.apust.emusicstore.model.Product;
import com.apust.emusicstore.service.CustomerService;
import com.apust.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by GUN
 * on 13.06.2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/productInventary")
    public String productInventary(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        return "productInventary";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model){

        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);

        return "customerManagement";
    }

}
