package com.estudo.domain;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_generator")
    @SequenceGenerator(name = "todo_generator", sequenceName = "todo_sequence")
    private Integer id;
    private String title;
    private String description;
    private Integer categoryId;

    //Getter's n' Setter's
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    //Constructor's
    public Todo() {
    }

    public Todo(String title, String description, Integer categoryId) {
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
    }
}
