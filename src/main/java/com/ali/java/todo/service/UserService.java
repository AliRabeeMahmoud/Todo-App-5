package com.ali.java.todo.service;

import com.ali.java.todo.dto.UserDto;
import com.ali.java.todo.model.User;

import java.util.List;


public interface UserService {

    UserDto save(User user);
    UserDto update(User user);

    List<UserDto> findAll();

    UserDto findById(Long id);

    String delete(Long id);


}
