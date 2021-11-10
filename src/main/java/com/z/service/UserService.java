package com.z.service;

import com.z.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    List<User> getAllUser();
    int updateUser(User user,int no);
    boolean addUser(User user);
    void removeUser(int id) ;
    User getUserByName(String name,String pwd) ;
}
