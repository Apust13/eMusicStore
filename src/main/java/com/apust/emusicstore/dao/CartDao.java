package com.apust.emusicstore.dao;

import com.apust.emusicstore.model.Cart;

import java.io.IOException;

/**
 * Created by GUN
 * on 11.05.2016.
 */
public interface CartDao {

    Cart getCartById (int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);

}
