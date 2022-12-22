package com.example.springcoreannotations.config;

import com.example.springcoreannotations.TestClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope("singleton")
public class TestConfiguration {

    @Bean
    public TestClass testClass(){
        return new TestClass();
    }
}
