package ru.example.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

/**
 * Капу пк
 * 21.03.2020
 */
@MappedSuperclass
public class AbstractNamedEntity extends AbstractBaseEntity {
    @Column(name = "name")
    @NotBlank
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
