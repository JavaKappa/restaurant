package ru.example.repository;

import ru.example.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant get(int id);

    Restaurant save(Restaurant restaurant);

    boolean delete(int id);

    List<Restaurant> getAll();

    List<Restaurant> getAllWithNoNullMenu();
}
