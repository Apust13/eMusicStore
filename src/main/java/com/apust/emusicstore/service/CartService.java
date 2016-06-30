package com.apust.emusicstore.service;

import com.apust.emusicstore.model.Cart;

/**
 * Created by GUN
 * on 14.06.2016.
 */
public interface CartService {

    Cart getCartById (int cartId);

    void update(Cart cart);
}
