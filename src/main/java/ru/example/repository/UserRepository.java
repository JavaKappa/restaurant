package ru.example.repository;

import ru.example.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    User get(int id);

    boolean delete(int id);

    List<User> getAll();
}
