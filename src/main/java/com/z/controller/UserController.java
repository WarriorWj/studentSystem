package com.z.controller;

import com.z.dao.UserDao;
import com.z.entity.User;
import com.z.service.Impl.UserServiceImpl;
import com.z.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    UserService userService =new UserServiceImpl();


    public  void getAllUser(){
        List<User> allUser = userService.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }

    }

    public void updateUser(){
        User user = new User();
        user.setName("admin");
        user.setPwd("123456");
        userService.updateUser(user,2);
    }

    public void addUser()  {
        User user = new User();
        user.setPwd("zhou");
        user.setName("zhou");
        userService.addUser(user);
    }

    public void removeUser() {
        int id = 3;
        userService.removeUser(id);
    }

    public void getUserByName() {
        String name="admin";
        String pwd="123456";
        User userByName = userService.getUserByName(name, pwd);
        System.out.println(userByName);


    }
}
