package ru.example.model;


import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Капу пк
 * 21.03.2020
 */

@Entity
@Table(name="users")
public class User extends AbstractNamedEntity {

    private Boolean vote_access = true;

    public boolean getVote_access() {
        return vote_access;
    }

    public void setVote_access(boolean vote_access) {
        this.vote_access = vote_access;
    }

    @Override
    public String toString() {
        return "User{" +
                "vote_access=" + vote_access +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
    public User() {
    }


}
