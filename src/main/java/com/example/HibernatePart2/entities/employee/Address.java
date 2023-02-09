package com.example.HibernatePart2.entities.employee;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetaddress;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    public String getStreetAddress() {
        return streetaddress;
    }

    @Override
    public String toString() {
        return "Address [streetaddress=" + streetaddress + ", city=" + city + ", state=" + state + ", country="
                + country + ", zipcode=" + zipcode + "]";
    }

    public void setStreetAddress(String streetAddress) {
        this.streetaddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
