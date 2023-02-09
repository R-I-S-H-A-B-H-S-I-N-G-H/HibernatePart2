package com.example.HibernatePart2.entities.one2many;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String number;
    private String type;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public PhoneNumber(String number, String type, Customer customer) {
        this.number = number;
        this.type = type;
        this.customer = customer;
    }

    public PhoneNumber(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public PhoneNumber() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
