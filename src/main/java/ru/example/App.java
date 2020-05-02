package ru.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.example.model.Meal;
import ru.example.model.Menu;
import ru.example.model.Restaurant;
import ru.example.repository.JpaRestaurantRepository;
import ru.example.web.user.UserController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            UserController controller = appCtx.getBean(UserController.class);

            JpaRestaurantRepository ms = appCtx.getBean(JpaRestaurantRepository.class);

            List<Meal> meals = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Meal meal = new Meal();
                meal.setName("meal " + i);
                meal.setPrice(i);
                meals.add(meal);
            }

            Menu menu = new Menu();
            menu.setMealList(meals);
            menu.setDate(LocalDate.now());

            Restaurant restaurant = new Restaurant();
            restaurant.setName("DOBRINYA");
            restaurant.setMenu(menu);
            ms.save(restaurant);
        }
    }
}
