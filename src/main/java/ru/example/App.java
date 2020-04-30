package ru.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.example.model.User;
import ru.example.web.user.UserRestController;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            UserRestController controller = appCtx.getBean(UserRestController.class);
            User us = new User();
            us.setId(1);
            us.setName("Igor");
            us.setVote_access(true);
            controller.save(us);
            System.out.println(controller.get(us.getId()));
        }
    }
}
