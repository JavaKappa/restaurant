package ru.example.web.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.example.model.Restaurant;
import ru.example.service.RestaurantService;

import java.util.List;

/**
 * Капу пк
 * 02.05.2020
 */
@Controller
public class RestaurantController {
    private final RestaurantService service;

    @Autowired
    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    public List<Restaurant> getAllRestaurantsVsNoNullMenu() {
        return service.getAllRestaurantsVsNoNullMenu();
    }

    public Restaurant save(Restaurant restaurant) {
        return service.save(restaurant);
    }
}
