package com.berant.berta.data;


import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    private int id;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "price_buy")
    public double getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(double priceBuy) {
        this.priceBuy = priceBuy;
    }
}
