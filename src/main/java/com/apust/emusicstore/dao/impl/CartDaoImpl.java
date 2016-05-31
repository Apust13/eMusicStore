package com.apust.emusicstore.dao.impl;

import com.apust.emusicstore.dao.CartDao;
import com.apust.emusicstore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by GUN
 * on 11.05.2016.
 */
@Repository
public class CartDaoImpl implements CartDao {

    private Map<Integer, Cart> listOfCarts;

    public CartDaoImpl(){
        listOfCarts = new HashMap<Integer, Cart>();
    }

    public Cart create(Cart cart) {

        if(listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Cannot create a cart. A cart with the given id(%)" +
                    "already " + "exist", cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    public Cart read(int cartId) {
        return listOfCarts.get(cartId);
    }

    public void update(int cartId, Cart cart) {
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Can not update cart. The cart with the given id(%)" +
                    "doesn't " + "exist", cart.getCartId()));
        }
        listOfCarts.put(cartId, cart);

    }

    public void delete(int cartId) {

        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Can not delete the cart. The cart with the given id(%)" +
                    "does not " + "exist", cartId));
        }
        listOfCarts.remove(cartId);

    }
}
