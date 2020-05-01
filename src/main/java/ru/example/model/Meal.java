package ru.example.model;

import javax.persistence.*;

@Entity
@Table(name = "meals")
public class Meal extends AbstractNamedEntity{
    private double price;
    @ManyToOne
    private Menu menu;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
