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
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            UserRestController controller = appCtx.getBean(UserRestController.class);
            controller.delete(0);
        }
    }
}
