package ru.example.model;

import java.time.LocalDate;
import java.util.List;

public class Menu extends AbstractBaseEntity{
    private LocalDate date;
    private List<Meal> mealList;


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
