package com.example.HibernatePart2.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.HibernatePart2.entities.one2many.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

}
