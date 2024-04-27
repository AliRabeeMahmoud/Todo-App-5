package com.ali.java.todo.service.impl;

import com.ali.java.todo.model.Todo;
import com.ali.java.todo.repository.CategoryRepository;
import com.ali.java.todo.repository.TodoRepository;
import com.ali.java.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;




@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {



    private final TodoRepository todoRepository;


    private final CategoryRepository categoryRepository;

    @Override
    public Todo save(Todo todo) {

        return todoRepository.save(todo);
    }

    @Override
    public Todo update(Todo todo) {
        Todo oldTodo = todoRepository.findById(todo.getId()).orElse(null);
        oldTodo.setCategory(todo.getCategory());
        oldTodo.setTitle(todo.getTitle());
        oldTodo.setDescription(todo.getDescription());
        oldTodo.setDone(todo.getDone());
        oldTodo.setFavorite(todo.getFavorite());
        return oldTodo;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(Long id) {

        return todoRepository.findById(id).orElse(null);
    }


    @Override
    public String delete(Long id) {

        todoRepository.deleteById(id);
        return "Deleted";
    }
}
