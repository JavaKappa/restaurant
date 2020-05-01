package ru.example.repository;

import org.springframework.stereotype.Repository;
import ru.example.model.Meal;
import ru.example.model.Menu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class JpaMenuSaver {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Menu save(Menu menu) {
        if (menu.isNew()) {
            em.persist(menu);
        } else {
            em.merge(menu);
        }
        return menu;
    }

}
