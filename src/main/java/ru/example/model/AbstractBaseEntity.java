package ru.example.model;

import javax.persistence.*;

/**
 * Капу пк
 * 21.03.2020
 */
@MappedSuperclass

public abstract class AbstractBaseEntity {
    private static final int START_SEQ = 10000;
    @Id
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1, initialValue = START_SEQ)
//    //@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
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
