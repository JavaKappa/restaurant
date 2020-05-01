package ru.example.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import ru.example.model.Restaurant;
import ru.example.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaRestaurantRepository implements RestaurantRepository {
    @PersistenceContext
    private EntityManager em;

    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNew()) {
            em.persist(restaurant);
            return restaurant;
        } else {
            return em.merge(restaurant);
        }
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Restaurant> getAll() {
        return null;
    }

    public Restaurant get(int id) {
        return em.find(Restaurant.class, id);
    }
}
