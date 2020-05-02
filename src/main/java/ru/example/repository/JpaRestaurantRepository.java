package ru.example.repository;

import org.springframework.stereotype.Repository;
import ru.example.model.Restaurant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public class JpaRestaurantRepository implements RestaurantRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public Restaurant get(int id) {
        return null;
    }

    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNew()) {
            em.persist(restaurant);
        } else {
            em.merge(restaurant);
        }
        return restaurant;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Restaurant> getAll() {
        return null;
    }

    @Override
    @Transactional
    public List<Restaurant> getAllWithNoNullMenu() {
        //TODO
        Query query = em.createQuery("SELECT Restaurant FROM Restaurant r");
        query.setParameter("date", LocalDate.now());
        return query.getResultList();
    }

}
