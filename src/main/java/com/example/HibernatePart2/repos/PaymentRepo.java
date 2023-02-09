package com.example.HibernatePart2.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.HibernatePart2.entities.inheritance.Payment;

public interface PaymentRepo extends CrudRepository<Payment, Integer> {

}
