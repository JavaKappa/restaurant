package ru.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.model.User;
import ru.example.repository.JpaUserRepository;

import java.util.List;

@Service
public class UserService {
    private final JpaUserRepository repository;
    @Autowired
    public UserService(JpaUserRepository repository) {
        this.repository = repository;
    }
    public User save(User user) {
        return repository.save(user);
    }

    public User get(int id) {
        return repository.get(id);
    }

    public User update(User user) {
        //TODO
        return repository.save(user);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }

    public List<User> getAll() {
        return repository.getAll();
    }
}
