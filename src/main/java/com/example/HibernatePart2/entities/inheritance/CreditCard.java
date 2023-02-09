package com.example.HibernatePart2.entities.inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("cc")
public class CreditCard extends Payment {
    private String cardNumber;

    public String getCardNumbe() {
        return cardNumber;
    }

    public void setCardNumbe(String cardNumbe) {
        this.cardNumber = cardNumbe;
    }

}
