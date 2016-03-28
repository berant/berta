package com.berant.berta.data;


public class Product {
    private Integer id;
    private String name;
    private String description;
    private Category category;
    private double priceBuy;

    public String toString() {
        return "Product {id=" + id
                + "; name=" + name
                + "; description=" + description
                + "; category=" + category
                + "; priceBuy=" + priceBuy
                + "}";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(double priceBuy) {
        this.priceBuy = priceBuy;
    }
}
