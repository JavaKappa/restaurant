package ru.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.model.Meal;
import ru.example.model.Restaurant;
import ru.example.repository.RestaurantRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository repository;
    @Autowired
    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public Restaurant get(int id) {
        return repository.get(id);
    }

    public List<Restaurant> getAllRestaurantsVsNoNullMenu() {
        return repository.getAllWithNoNullMenu();
    }

    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Transactional
    public Meal addMealToMenu(String mealName, double mealPrice, int restaurantId, LocalDate menuDate){
        Restaurant updatedRestaurant = repository.get(restaurantId);
        Meal meal = updatedRestaurant.addMeal(mealName, mealPrice,  menuDate);
        repository.save(updatedRestaurant);
        return meal;
    }
}
