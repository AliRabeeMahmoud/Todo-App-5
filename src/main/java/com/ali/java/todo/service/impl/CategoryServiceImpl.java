package com.ali.java.todo.service.impl;

import com.ali.java.todo.model.Category;
import com.ali.java.todo.repository.CategoryRepository;
import com.ali.java.todo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category oldCategory = categoryRepository.findById(category.getId()).orElse(null);
        oldCategory.setDescription(category.getDescription());
        oldCategory.setName(category.getName());

        return oldCategory;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();

    }

    @Override
    public Category findById(Long id) {

        return categoryRepository.findById(id).orElse(null);
    }



    @Override
    public String delete(Long id) {

        categoryRepository.deleteById(id);
        return "Deleted";
    }


}
