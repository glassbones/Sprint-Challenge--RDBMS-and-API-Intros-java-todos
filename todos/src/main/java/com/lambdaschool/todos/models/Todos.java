package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todos extends Auditable {

    /** Variables **/

    //generate an ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    // description var
    private String description;

    // status var
    private boolean completed = false;

    //link to User model ( many todos to one user )
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties(value = "todos")
    private User user;

    /** Constructors **/

    // empty constructor ( required )
    public Todos() { }

    // constructor
    public Todos(User user, String description) {
        this.user = user;
        this.description = description;
    }

    /** Get / Set **/

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}