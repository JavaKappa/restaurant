package ru.example.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Menu extends AbstractBaseEntity {
    private LocalDate date;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id")
    private List<Meal> mealList;
//    @OneToOne
//    private Restaurant restaurant;


//    public Restaurant getRestaurant() {
//        return restaurant;
//    }
//
//    public void setRestaurant(Restaurant restaurant) {
//        this.restaurant = restaurant;
//    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }
}
