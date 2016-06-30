package com.apust.emusicstore.service;

import com.apust.emusicstore.model.Customer;

import java.util.List;

/**
 * Created by GUN
 * on 14.06.2016.
 */
public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);




}
