package ru.example.repository;

import org.springframework.stereotype.Repository;
import ru.example.model.Meal;
import ru.example.model.Menu;
import ru.example.model.Restaurant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaRestaurantRepository implements RestaurantRepository {
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
    @Transactional
    public boolean delete(int id) {
        return em.createQuery("DELETE from Restaurant r where r.id=:id")
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public List<Restaurant> getAll() {
        return null;
    }

    @Override
    @Transactional
    public List<Restaurant> getAllWithNoNullMenu() {
        Query query = em.createQuery("select m from Menu m where m.date=:date");
        query.setParameter("date", LocalDate.now());
        List<Menu> currentMenuList = (List<Menu>) query.getResultList();
        List<Restaurant> restaurantList = currentMenuList.stream().filter(m -> !m.getMealList().isEmpty()).map(Menu::getRestaurant).collect(Collectors.toList());
        return restaurantList;
    }
}
