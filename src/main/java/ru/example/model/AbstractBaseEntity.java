package ru.example.model;

/**
 * Капу пк
 * 21.03.2020
 */
public abstract class AbstractBaseEntity {
    protected Integer id;

    public AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    public AbstractBaseEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
