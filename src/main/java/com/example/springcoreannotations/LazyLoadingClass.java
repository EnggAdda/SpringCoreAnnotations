package com.example.springcoreannotations;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyLoadingClass {
    public LazyLoadingClass() {

        System.out.println("Lazy loading class object created ");
    }
}
