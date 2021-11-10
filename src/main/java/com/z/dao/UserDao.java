package com.z.dao;

import com.z.entity.User;
import com.z.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public User selectOne(String name,String pwd){
        Connection connect=null;
        PreparedStatement ps =null;
        try {
            // 得到连接
            connect = JDBCUtils.getConnect();
            // sql语句
            String sql = "select * from user where name=? and pwd=?";
            // 预编译
           ps = connect.prepareStatement(sql);
            // 设置占位符
            ps.setString(1, name);
            ps.setString(2, pwd);
            // 执行
            ResultSet rs = ps.executeQuery();
            // 新建一个List来接收User
            User user = new User();
            // 如果有的话就设置
            while (rs.next()) {
                int id = rs.getInt(1);
                String name1 = rs.getString(2);
                String pwd1 = rs.getString(3);
                user.setId(id);
                user.setName(name1);
                user.setPwd(pwd1);
            }
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            // 释放连接
            JDBCUtils.close(connect,null,ps);
        }

    }

    public void deleteUser(int no) {
        Connection connect=null;
        PreparedStatement ps=null;
        try {
            // 得到连接
            connect = JDBCUtils.getConnect();
            // sql语句
            String sql = "delete from user where id=?";
            // 预编译SQL语句
            ps = connect.prepareStatement(sql);
            // 设置占位符
            ps.setInt(1, no);
            // 执行
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭连接
            JDBCUtils.close(connect,null,ps);
        }

    }

    public int updateUser(User user,int sno) {
        Connection connect=null;
        PreparedStatement ps=null;
        try {
            // 得到连接
            connect = JDBCUtils.getConnect();
            // 设置sql语句
            String sql = "update user set name=?,pwd=? where id=?";
            // 预编译sql语句
            ps = connect.prepareStatement(sql);
            // 设置参数
            ps.setString(1, user.getName());
            ps.setString(2, user.getPwd());
            ps.setInt(3, sno);
            // 执行
            int i = ps.executeUpdate();
            return i;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            // 关闭连接
            JDBCUtils.close(connect,null,ps);
        }
    }

    public  List<User> selectAllUser()  {
        // 新建一个List集合用来接收查询到的数据
        List<User> userList=new ArrayList<>();
        Connection connect=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;
        try {
            // 得到连接
          connect = JDBCUtils.getConnect();
            // 设置SQL语句
            String sql = "select * from user";
            // 预编译SQL语句
            preparedStatement = connect.prepareStatement(sql);
            // 查询结果
            resultSet = preparedStatement.executeQuery();

            // 如果有结果的话
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String pwd = resultSet.getString(3);
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setPwd(pwd);
                userList.add(user);
            }
            return userList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            // 执行完毕后关闭资源
            JDBCUtils.close(connect,resultSet,preparedStatement);
        }


    }

    public boolean insertUser(User user)  {
        Connection connect=null;
        PreparedStatement ps=null;
        try {
        // 得到连接
        connect = JDBCUtils.getConnect();
        // sql语句
        String sql="insert into user(name,pwd) value(?,?)";
        // 预编译
        ps = connect.prepareStatement(sql);
        // 插入数据
        ps.setString(1,user.getName());
        ps.setString(2,user.getPwd());
        // 执行插入
        boolean execute = ps.execute();
        return execute;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            // 关闭连接
            JDBCUtils.close(connect,null,ps);
        }


    }
}
