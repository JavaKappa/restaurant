package ru.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.example.model.Meal;
import ru.example.model.User;
import ru.example.repository.JpaMealSaver;
import ru.example.web.user.UserRestController;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            UserRestController controller = appCtx.getBean(UserRestController.class);

            JpaMealSaver ms = appCtx.getBean(JpaMealSaver.class);
            Meal meal = new Meal();
            meal.setPrice(122);
            meal.setName("Octoupos");
            ms.save(meal);
        }
    }
}
