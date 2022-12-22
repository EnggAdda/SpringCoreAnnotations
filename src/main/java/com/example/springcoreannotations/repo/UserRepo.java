package com.example.springcoreannotations.repo;


import com.example.springcoreannotations.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
