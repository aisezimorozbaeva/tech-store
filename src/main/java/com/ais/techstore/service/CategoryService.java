package com.ais.techstore.service;


import com.ais.techstore.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(long id);
    Category findCategoryByName(String name);
    void save(Category category);
    void deleteById(long id);
}
