package com.apust.emusicstore.service.impl;

import com.apust.emusicstore.dao.CartDao;
import com.apust.emusicstore.model.Cart;
import com.apust.emusicstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GUN
 * on 14.06.2016.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;


    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    public void update(Cart cart) {
        cartDao.update(cart);

    }
}
