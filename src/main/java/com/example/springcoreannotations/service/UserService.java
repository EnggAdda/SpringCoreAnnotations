package com.example.springcoreannotations.service;


import com.example.springcoreannotations.entity.User;
import com.example.springcoreannotations.exception.UserNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    void insertUser(User user);

    User getUserById (int id ) throws UserNotFoundException;

    List<User> getAllUsers();

    User updateUserById(User user , int id);

    User updateFieldsOfUserById(int id, Map<String , Optional> map);

    void deleteUserById(int id);
}
