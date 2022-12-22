package com.example.springcoreannotations.controller;


import com.example.springcoreannotations.LazyLoadingClass;
import com.example.springcoreannotations.TestClass;
import com.example.springcoreannotations.entity.User;
import com.example.springcoreannotations.exception.UserNotFoundException;
import com.example.springcoreannotations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@PropertySource("classpath:custom.properties")
@Scope("prototype")
public class UserController {
    public UserController() {
        System.out.println("controlller");
    }

    @Autowired
    //@Qualifier("userServiceImpl")
    private UserService userService;


     @Autowired
     private TestClass testClass;

     @Autowired
     private LazyLoadingClass lazyLoadingClass;

     @Value("${spring.datasource.url}")
    private String url ;
    @Value("${spring.datasource.username}")
    private String username ;
    @Value("${spring.datasource.password}")
    private String pass;

    @Value("${msg}")
    private String msg;
    @PostMapping("/insert")
   //@RequestMapping(value ="/insert" ,method= RequestMethod.POST)
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);

    }



   @GetMapping("/User/{id}")
    public User getUserById(@PathVariable int id) throws UserNotFoundException {
       return userService.getUserById(id);

    }


    @PutMapping("/Update/{id}")
    public User updateUserById(@RequestBody User user, @PathVariable int id){
        return userService.updateUserById(user,id);

    }@GetMapping("/get/idByReq")
    public User getUserByIdRequestParam(@RequestParam("id") int id ) throws UserNotFoundException {
        return userService.getUserById(id);

    }

    @PatchMapping("/UpdateByPatch/{id}")
    public User updateByPatch(@PathVariable int id, @RequestBody Map<String, Optional> map ){
        return userService.updateFieldsOfUserById(id,map);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable int id){
          userService.deleteUserById(id);

    }

    @GetMapping("/findAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();

    }

    @GetMapping("/all")
    public String getAll() {

        System.out.println("url :- "+url +"username  :- " +username +"password " +pass +" msg" +msg);
       return testClass.getMessage();

    }

}
