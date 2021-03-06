package com.apust.emusicstore.controller;

import com.apust.emusicstore.dao.CartDao;
import com.apust.emusicstore.dao.ProductDao;
import com.apust.emusicstore.model.Cart;
import com.apust.emusicstore.model.CartItem;
import com.apust.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by GUN
 * on 11.05.2016.
 */

@Controller
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable(value = "cartId") int cartId){
        return cartDao.read(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") int cartId, @RequestBody Cart cart){
        cartDao.update(cartId, cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") int cartId){
        cartDao.delete(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") int productId, HttpServletRequest request){
        int sessionId = Integer.getInteger(request.getSession(true).getId());
        Cart cart = cartDao.read(sessionId);

        if(cart == null){
             cart = cartDao.create(new Cart(sessionId));
        }

        Product product = productDao.getProductById(productId);
        if(product == null){
            throw new IllegalArgumentException(new Exception());
        }

        cart.addCartItem(new CartItem(product));
        cartDao.update(sessionId, cart);

    }

    @RequestMapping(value = "/remove/{productId}", method=RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int productId, HttpServletRequest request){
        int sessionId = Integer.getInteger(request.getSession(true).getId());
        Cart cart = cartDao.read(sessionId);

        if(cart == null){
            cart = cartDao.create(new Cart(sessionId));
        }

        Product product = productDao.getProductById(productId);
        if(product == null){
            throw new IllegalArgumentException(new Exception());
        }

        cart.removeCartItem(new CartItem(product));
        cartDao.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server Error")
    public void handleServerError(Exception e){}

}
