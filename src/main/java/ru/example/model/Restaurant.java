package ru.example.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "restaurant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Menu> menus = new ArrayList<>();


    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public Meal addMeal(String  mealName, double mealPrice, LocalDate dateMenu) {
        Meal meal = new Meal(mealName, mealPrice);
        Menu m = menus.stream()
                .filter(menu -> menu.getDate().equals(dateMenu))
                .findFirst().orElse(null);
        if (m == null) {
            m = new Menu();
            m.setDate(dateMenu);
            addMenu(m);
        }
        m.addMeal(meal);
        return meal;
    }

}
