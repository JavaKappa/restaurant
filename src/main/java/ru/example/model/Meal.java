package ru.example.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "meals")
public class Meal extends AbstractNamedEntity{
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}