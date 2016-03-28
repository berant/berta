package com.berant.berta.data.dao;

import com.berant.berta.data.Category;

import java.util.List;


public interface CategoryDao {
    Category find(int id);
    List<Category> findAllRoot();
    void insert(Category productCategory);
    void update(Category productCategory);
    void delete(int id);
}
