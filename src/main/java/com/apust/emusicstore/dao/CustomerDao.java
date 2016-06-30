package com.apust.emusicstore.dao;

import com.apust.emusicstore.model.Customer;

import java.util.List;

/**
 * Created by GUN
 * on 14.06.2016.
 */
public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);

}
