package com.apust.emusicstore.service;

import com.apust.emusicstore.model.CustomerOrder;

/**
 * Created by GUN
 * on 14.06.2016.
 */
public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    int getCustomerOrderGrandTotal(int cartId);
}
