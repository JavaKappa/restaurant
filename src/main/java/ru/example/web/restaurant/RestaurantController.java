package ru.example.web.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.example.service.RestaurantService;

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

    public RestaurantService getService() {
        return service;
    }
}
