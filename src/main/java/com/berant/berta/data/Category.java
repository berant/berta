package com.berant.berta.data;


public class Category {

    public static final String DELIMITER = "->";

    private int id;
    private String name;

    public String toString() {
        return "Category {id=" + id
                + "; name=" + name
                + "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
