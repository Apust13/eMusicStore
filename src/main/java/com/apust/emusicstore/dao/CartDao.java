package com.apust.emusicstore.dao;

import com.apust.emusicstore.model.Cart;

/**
 * Created by GUN
 * on 11.05.2016.
 */
public interface CartDao {

    Cart create (Cart cart);

    Cart read (int cartId);

    void update (int cartId, Cart cart);

//TODO: check argyments types in methods
    void delete (int cartId);

}
