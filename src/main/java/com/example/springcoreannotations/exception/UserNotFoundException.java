package com.example.springcoreannotations.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String s) {
         super(s);
    }
}
