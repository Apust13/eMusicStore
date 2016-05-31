package com.apust.emusicstore.controller;

import com.apust.emusicstore.dao.ProductDao;
import com.apust.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by GUN
 * on 05.05.2016.
 */

@Controller
public class AdminController {

    private Path path;

    @Autowired
    private ProductDao productDao;

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
        product.setProductStatus("active");


        model.addAttribute("product", product);
        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventary/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product,BindingResult result, HttpServletRequest request){

        if(result.hasErrors()){
            return "addProduct";

        }


        productDao.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".jpg");

        if(productImage != null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed");
            }
        }


        return "redirect:/admin/productInventary";

    }

    @RequestMapping("/admin/productInventary/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId, Model model, HttpServletRequest request) {

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + productId + ".jpg");

        if(Files.exists(path)){

            try{
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        productDao.deleteProduct(productId);

        return "redirect:/admin/productInventary";
    }

    @RequestMapping("/admin/productInventary/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        Product product = productDao.getProductById(id);

        model.addAttribute(product);

        return "editProduct";

    }

    @RequestMapping(value = "/admin/productInventary/editProduct", method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute("product") Product product, Model model,BindingResult result, HttpServletRequest request){

        if(result.hasErrors()){
            return "editProduct";

        }

        MultipartFile productImage = product.getProductImage();

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".jpg");

        if(productImage != null && !productImage.isEmpty()){

            try{
                productImage.transferTo(new File(path.toString()));
            }catch (Exception e){
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        productDao.editProduct(product);

        return "redirect:/admin/productInventary";


    }




}
