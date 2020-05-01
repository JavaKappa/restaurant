package ru.example.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.example.model.User;
import ru.example.service.UserService;

import java.util.List;

@Controller
public class UserRestController {
    @Autowired
    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    public User save(User user) {
        return userService.save(user);
    }

    public User get(int id) {
        return userService.get(id);
    }

    public User update(User user) {
        return userService.update(user);
    }

    public boolean delete(int id) {
        return userService.delete(id);
    }

    public List<User> getAll() {
        return userService.getAll();
    }
}
