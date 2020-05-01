package ru.example.repository;

import org.springframework.stereotype.Repository;
import ru.example.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class JpaUserRepository implements UserRepository{
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }


    @Override
    @Transactional
    public boolean delete(int id) {
        Query query = em.createQuery("DELETE FROM User u WHERE u.id=:id");
        return query.setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public List<User> getAll() {
        Query query = em.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }
}
