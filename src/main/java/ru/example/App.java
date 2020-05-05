package ru.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.example.model.Meal;
import ru.example.model.Menu;
import ru.example.model.Restaurant;
import ru.example.web.restaurant.RestaurantController;

import java.time.LocalDate;
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
                Meal meal = new Meal("menu " + i, i);
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

            Restaurant restaurant3 = new Restaurant();
            restaurant3.setName("Leshiy_pub");
            Menu menuForLeshiy = new Menu();
            menuForLeshiy.setDate(LocalDate.now());
            menuForLeshiy.addMeal(new Meal("PLOV", 33.33));
            menuForLeshiy.addMeal(new Meal("LAGMAN", 63.33));
            restaurant3.addMenu(menuForLeshiy);
            rs.save(restaurant3);

            List<Restaurant> restaurants = rs.getAllRestaurantsVsNoNullMenu();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(restaurant.getId() + restaurant1.getId());
            restaurants.forEach((m)-> System.out.println(m.getId() + m.getName() ));
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
