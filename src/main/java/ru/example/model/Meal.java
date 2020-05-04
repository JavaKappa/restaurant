package ru.example.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "meals")
public class Meal extends AbstractNamedEntity{
    private double price;
    @ManyToOne
    private Menu menu;

    public Meal(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Meal() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
