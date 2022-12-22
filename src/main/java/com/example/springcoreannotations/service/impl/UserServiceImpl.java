package com.example.springcoreannotations.service.impl;


import com.example.springcoreannotations.entity.User;
import com.example.springcoreannotations.exception.UserNotFoundException;
import com.example.springcoreannotations.repo.UserRepo;
import com.example.springcoreannotations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
@Primary
public class UserServiceImpl implements UserService {



    @Autowired
    private UserRepo userRepo;

    @Override
    public void insertUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User getUserById(int id) throws UserNotFoundException {
     User user = userRepo.findById(id).get();
        if(user!=null){
            return user;
        }
        else {
            throw new UserNotFoundException("user with id "+id +"not found");
        }

    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User updateUserById(User user, int id) {
       User  userFromDb  = userRepo.findById(id).get();//1rst
          userFromDb.setName(user.getName());
          userFromDb.setFatherName(user.getFatherName());
          userFromDb.setAddress(user.getAddress());
          userFromDb.setAge(user.getAge());

        return userRepo.save(userFromDb);
    }

    @Override
    public User updateFieldsOfUserById(int id, Map<String, Optional> map) {

         User userFromDb  = userRepo.findById(id).get();

          for(Map.Entry<String ,Optional>  hm :map.entrySet()){

               String keyFromMap = hm.getKey();

                if(keyFromMap.equals("name")){

                    Optional<Object> oa = hm.getValue();
                    String value = oa.map (Object::toString).orElse (null);
                    userFromDb.setName(value);

                }

              if(keyFromMap.equals("fatherName")){

                  Optional<Object> oa = hm.getValue();
                  String value = oa.map (Object::toString).orElse (null);
                  userFromDb.setFatherName(value);

              }

              if(keyFromMap.equals("address")){

                  Optional<Object> oa = hm.getValue();
                  String value = oa.map (Object::toString).orElse (null);
                  userFromDb.setAddress(value);

              }

              if(keyFromMap.equals("age")){

                  Optional<Integer> oa = hm.getValue();
                  Integer value = Integer.valueOf(oa.get());
                  userFromDb.setAge(value);

              }
          }


        return userRepo.save(userFromDb);
    }

    @Override
    public void deleteUserById(int id) {

        userRepo.deleteById(id);

    }
}
