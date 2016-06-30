package com.apust.emusicstore.service.impl;

import com.apust.emusicstore.dao.CartItemDao;
import com.apust.emusicstore.model.Cart;
import com.apust.emusicstore.model.CartItem;
import com.apust.emusicstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GUN
 * on 14.06.2016.
 */

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;


    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);

    }

    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);

    }

    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);

    }

    public CartItem getCartItemByProductId(int productId){
        return cartItemDao.getCartItemByProductId(productId);
    }
}
