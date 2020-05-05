package ru.example.repository;

import org.springframework.stereotype.Repository;
import ru.example.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class JpaUserRepository {
    @PersistenceContext
    private EntityManager em;


    @Transactional
    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    public User get(int id) {
        return em.find(User.class, id);
    }


    @Transactional
    public boolean delete(int id) {
        Query query = em.createQuery("DELETE FROM User u WHERE u.id=:id");
        return query.setParameter("id", id).executeUpdate() != 0;
    }

    public List<User> getAll() {
        Query query = em.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }
}
