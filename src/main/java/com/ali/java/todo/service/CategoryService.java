package com.ali.java.todo.service;

import com.ali.java.todo.model.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);
    Category update(Category category);

    List<Category> findAll();

    Category findById(Long id);


    String delete(Long id);


}
