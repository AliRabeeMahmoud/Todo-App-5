package com.ali.java.todo.controller;


import com.ali.java.todo.dto.UserDto;
import com.ali.java.todo.model.User;
import com.ali.java.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController  {



    private final UserService userService;



    @PostMapping
    public UserDto createUser(@RequestBody User user) {
        return userService.save(user);
    }


    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id,@RequestBody User user) {
        return userService.update(user);
    }


    @GetMapping
    public List<UserDto>getAllUsers() {
        return userService.findAll();
    }


    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.findById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.delete(id);

    }
}
