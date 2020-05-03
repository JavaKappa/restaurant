package ru.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.example.model.Meal;
import ru.example.model.Menu;
import ru.example.model.Restaurant;
import ru.example.web.restaurant.RestaurantController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            RestaurantController rs = appCtx.getBean(RestaurantController.class);

            Restaurant restaurant = new Restaurant();
            restaurant.setName("DOBRINYA");
            Menu menu = new Menu();
            List<Meal> meals = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Meal meal = new Meal();
                meal.setName("meal " + i);
                meal.setPrice(i);
                meals.add(meal);
            }
            menu.setMealList(meals);
            menu.setDate(LocalDate.now());
            restaurant.addMenu(menu);
            rs.save(restaurant);

            Restaurant restaurant1 = new Restaurant();
            restaurant1.setName("arizona");
            Menu menu1 = new Menu();
            menu1.setDate(LocalDate.now().minusDays(4));
            restaurant1.addMenu(menu1);
            rs.save(restaurant1);

            List<Restaurant> restaurants = rs.getAllRestaurantsVsNoNullMenu();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(restaurants);
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
