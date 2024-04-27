package com.ali.java.todo.controller;

import com.ali.java.todo.model.Category;
import com.ali.java.todo.service.CategoryService;
import com.ali.java.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController  {


    private final TodoService todoService;


    private final CategoryService categoryService;


    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.update(category), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }




    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return categoryService.delete(id);

    }



}
