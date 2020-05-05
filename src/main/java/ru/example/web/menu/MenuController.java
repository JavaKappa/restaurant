package ru.example.web.menu;

import org.springframework.stereotype.Controller;
import ru.example.model.Meal;
import ru.example.model.Menu;

@Controller
public class MenuController {


    public Menu getMenuInTodat() {
        return null;
    }
    public Menu addMenuOnToday(Menu menu, int restaurantId) {
        return null;
    }

    public Meal editMenuOnToday(Menu menu, int restaurantId) {
        return null;
    }

    public boolean removeMenuFromToday(int menuId, int restaurantId) {
        return false;
    }
}
