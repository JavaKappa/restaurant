package ru.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.model.User;
import ru.example.repository.UserRepository;
@Service

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
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

    public void delete(int id) {
        repository.delete(id);
    }
}
