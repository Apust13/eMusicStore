package com.apust.emusicstore.dao;

import com.apust.emusicstore.model.Cart;
import com.apust.emusicstore.model.CartItem;

/**
 * Created by GUN
 * on 14.06.2016.
 */
public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);

}
