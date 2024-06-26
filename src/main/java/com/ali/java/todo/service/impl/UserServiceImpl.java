package com.ali.java.todo.service.impl;

import com.ali.java.todo.dto.UserDto;
import com.ali.java.todo.model.User;
import com.ali.java.todo.repository.UserRepository;
import com.ali.java.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final ModelMapper mapper;
    private final UserRepository userRepository;

    @Override
    public UserDto save(User user) {

        return toUserDto(userRepository.save(user));
    }

    @Override
    public UserDto update(User user) {
        User oldUser = userRepository.findById(user.getId()).orElse(null);
        oldUser.setUserName(user.getUserName());
        oldUser.setCategory(user.getCategory());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        userRepository.save(oldUser);
        return toUserDto(oldUser);
    }

    @Override
    public List<UserDto> findAll() {

       return userRepository.findAll()
               .stream()
               .map(this::toUserDto)
               .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {

        return toUserDto(userRepository.findById(id).orElse(null)) ;
    }

    @Override
    public String delete(Long id) {

        userRepository.deleteById(id);
        return "Deleted";

    }

    private UserDto toUserDto(User user){

    return mapper.map(user, UserDto.class);
    }




}
