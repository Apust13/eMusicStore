package com.apust.emusicstore.dao;

import com.apust.emusicstore.model.CustomerOrder;

/**
 * Created by GUN
 * on 14.06.2016.
 */
public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);

    int getCustomerOrderGrandTotal(int cartId);

}
