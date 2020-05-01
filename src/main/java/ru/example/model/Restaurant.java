package ru.example.model;


import javax.persistence.*;

//@Entity
//@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {
//    @OneToOne
//    @JoinColumn("menu")
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
