package ru.example.model;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Капу пк
 * 21.03.2020
 */
@NamedQueries({
    @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u ORDER BY u.getName")
})
@Entity
@Table(name = "USERS")
public class User extends AbstractNamedEntity {
    @Column(name = "ACCESS_VOTE")
    @NotNull
    private boolean vote_access = true;

    public static final String DELETE = "User.delete";
    public static final String ALL_SORTED = "User.getAllSorted";


    public User() {
    }

    public boolean isVote_access() {
        return vote_access;
    }

    public void setVote_access(boolean vote_access) {
        this.vote_access = vote_access;
    }

    public boolean isNew() {
        return id == null;
    }
}
