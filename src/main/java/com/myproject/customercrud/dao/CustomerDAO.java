package com.myproject.customercrud.dao;

import com.myproject.customercrud.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> findAll();

    public Customer findById(int theId);

    public void save(Customer theCustomer);

    public void deleteById(int theId);
}
