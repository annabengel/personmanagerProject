package com.pm.db;

import org.springframework.data.repository.CrudRepository;

import com.pm.business.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
