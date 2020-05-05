package ru.example.service;

import org.springframework.stereotype.Service;
import ru.example.model.Meal;
import ru.example.model.Menu;

@Service
public class MenuService {

    public Menu getMenu(int id, int restaurantId) {
        return null;
    }

    public Menu addMenu(Menu menu, int restaurantId) {
        return null;
    }

    public Meal editMenu(Menu menu, int restaurantId) {
        return null;
    }

    public boolean removeMenu(int menuId, int restaurantId) {
        return false;
    }
}
