package com.apust.emusicstore.service.impl;

import com.apust.emusicstore.dao.CustomerOrderDao;
import com.apust.emusicstore.model.Cart;
import com.apust.emusicstore.model.CartItem;
import com.apust.emusicstore.model.CustomerOrder;
import com.apust.emusicstore.service.CartService;
import com.apust.emusicstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GUN
 * on 14.06.2016.
 */

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;


    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public int getCustomerOrderGrandTotal(int cartId) {

        int grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for(CartItem item : cartItems){
            grandTotal+=item.getTotalPrice();
        }

        return grandTotal;
    }
}
