package ru.example.model;

/**
 * Капу пк
 * 21.03.2020
 */
public class AbstractNamedEntity extends AbstractBaseEntity {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
