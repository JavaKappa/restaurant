package ru.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.example.web.restaurant.RestaurantController;


@Controller
public class HelloController {
    @Autowired
    RestaurantController controller;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(Model model) {
        model.addAttribute("hello", controller.getAllRestaurantsVsNoNullMenu());
        return "index";
    }
}
