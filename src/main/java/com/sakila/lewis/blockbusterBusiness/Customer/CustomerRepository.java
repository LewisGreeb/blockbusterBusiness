package com.sakila.lewis.blockbusterBusiness.Customer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByFirstNameAndLastName(String first_name, String last_name);
}
