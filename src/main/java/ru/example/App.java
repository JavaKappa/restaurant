package ru.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.example.model.Meal;
import ru.example.model.Menu;
import ru.example.repository.JpaMenuSaver;
import ru.example.web.user.UserRestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            UserRestController controller = appCtx.getBean(UserRestController.class);

            JpaMenuSaver ms = appCtx.getBean(JpaMenuSaver.class);

            List<Meal> meals = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Meal meal = new Meal();
                meal.setName("menuItem + " + i);
                meals.add(meal);
            }

            Menu menu = new Menu();
            menu.setMealList(meals);
            menu.setDate(LocalDate.now());
            ms.save(menu);
        }
    }
}
