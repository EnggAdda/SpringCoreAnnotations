package com.example.springcoreannotations;

import org.springframework.stereotype.Component;

@Component
public class EagerLoadingClass
{
    public EagerLoadingClass() {
        System.out.println("eager loading class oject is created");
    }
}
