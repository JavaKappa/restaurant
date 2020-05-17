package ru.example.repository;

import ru.example.model.Menu;
import ru.example.model.Restaurant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class JpaMenuRepository {

    @PersistenceContext
    private EntityManager em;


    public Menu get(int id){
        return em.find(Menu.class, id);
    }

    public Menu add(Menu menu, int restaurantId) {
        Restaurant restaurant = em.find(Restaurant.class, restaurantId);
        if (restaurant.addMenu(menu)) {
            return menu;
        } else {
            throw new IllegalArgumentException("Menu on this day already exists");
        }
    }

    public boolean remove(int menuId, int restaurantId) {
//        em.createQuery("DELETE FROM Menu m ")
        return false;
    }
}
