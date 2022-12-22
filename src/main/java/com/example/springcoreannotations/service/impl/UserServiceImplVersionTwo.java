package com.example.springcoreannotations.service.impl;

import com.example.springcoreannotations.entity.User;
import com.example.springcoreannotations.exception.UserNotFoundException;
import com.example.springcoreannotations.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service

@Scope("singleton")
public class UserServiceImplVersionTwo implements UserService {

    public UserServiceImplVersionTwo() {

        System.out.println("UserServiceImplVersionTwo");
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public User getUserById(int id) throws UserNotFoundException {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User updateUserById(User user, int id) {
        return null;
    }

    @Override
    public User updateFieldsOfUserById(int id, Map<String, Optional> map) {
        return null;
    }

    @Override
    public void deleteUserById(int id) {

    }
}
