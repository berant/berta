package com.berant.berta.data.dao;

import com.berant.berta.data.Product;

import java.util.List;


public interface ProductDao {
    List<Product> findAll();
    Product find(int id);
    int insert(Product product);
    void update(Product product);
    void delete(int id);
}
