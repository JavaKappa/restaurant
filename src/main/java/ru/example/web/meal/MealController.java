package ru.example.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.example.model.Meal;
import ru.example.service.MealService;

import java.util.List;

@Controller
public class MealController {
    @Autowired
    private MealService service;

    public List<Meal> getAllMeals(int menuId) {
        return service.getAllMeals(menuId);
    }

    public Meal addMeal(Meal meal, int menuId) {
        return service.addMeal(meal, menuId);
    }

    public Meal updateMeal(Meal meal, int menuId) {
        return service.updateMeal(meal, menuId);
    }

    public boolean removeMeal(int id, int menuId) {
        return service.removeMeal(id, menuId);
    }
}
