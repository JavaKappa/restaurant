package ru.example.model;

import javax.persistence.*;

/**
 * Капу пк
 * 21.03.2020
 */
@MappedSuperclass

public abstract class AbstractBaseEntity {
    @Id
    @SequenceGenerator(name = "id")
//    //@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    public boolean isNew() {
        return id == null;
    }
}
