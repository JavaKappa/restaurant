package ru.example.repository;

import org.springframework.stereotype.Repository;
import ru.example.model.Meal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class JpaMealSaver {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Meal save(Meal meal) {
        if (meal.isNew()) {
            em.persist(meal);
        } else {
            em.merge(meal);
        }
        return meal;
    }

}
