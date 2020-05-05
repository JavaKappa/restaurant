package ru.example.web.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.example.model.Meal;
import ru.example.model.Menu;
import ru.example.service.MenuService;

@Controller
public class MenuController {
    @Autowired
    private MenuService service;


    public Menu getMenu(int id, int restaurantId) {
        return service.getMenu(id, restaurantId);
    }
    public Menu addMenu(Menu menu, int restaurantId) {
        return service.addMenu(menu, restaurantId);
    }

    public Meal editMenu(Menu menu, int restaurantId) {
        return service.editMenu(menu, restaurantId);
    }

    public boolean removeMenu(int menuId, int restaurantId) {
        return service.removeMenu(menuId, restaurantId);
    }
}
