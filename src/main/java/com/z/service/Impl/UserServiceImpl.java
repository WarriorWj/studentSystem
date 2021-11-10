package com.z.service.Impl;

import com.z.dao.UserDao;
import com.z.entity.User;
import com.z.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDao();

    @Override
    public List<User> getAllUser() {
        List<User> userList = userDao.selectAllUser();
        return userList;
    }

    @Override
    public int updateUser(User user, int no)  {
        int i = userDao.updateUser(user, no);
        return i;

    }

    @Override
    public boolean addUser(User user) {
        boolean b = userDao.insertUser(user);
        return b;
    }

    @Override
    public void removeUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUserByName(String name,String pwd){
        User user = userDao.selectOne(name, pwd);
        return user;
    }
}
