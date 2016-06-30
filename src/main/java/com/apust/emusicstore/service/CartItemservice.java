package com.apust.emusicstore.service;

import com.apust.emusicstore.model.Cart;
import com.apust.emusicstore.model.CartItem;

/**
 * Created by GUN
 * on 14.06.2016.
 */
public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);

}
