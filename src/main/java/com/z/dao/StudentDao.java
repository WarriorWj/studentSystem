package com.z.dao;

import com.z.entity.Student;
import com.z.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public List<Student> selectAllStudent() {
        Connection connect=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
        // 得到连接
         connect = JDBCUtils.getConnect();
        String sql="select * from student";
        // 预编译SQL
        preparedStatement = connect.prepareStatement(sql);
        // 执行SQL
        resultSet = preparedStatement.executeQuery();
        // 创建一个List集合用来接收Student
        List<Student> students=new ArrayList<>();
        while (resultSet.next()){
            Student student = new Student();
            int id = resultSet.getInt(1);
            String name= resultSet.getString(2);
            int age=resultSet.getInt(3);
            String sex=resultSet.getString(4);
            String address=resultSet.getString(5);
            student.setId(id);
            student.setName(name);
            student.setAge(age);
            student.setSex(sex);
            student.setAddress(address);
            students.add(student);
            }
            return  students;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtils.close(connect,resultSet,preparedStatement);
        }

    }


    public int updateStudent(Student student,int no){
        Connection connect=null;
        PreparedStatement ps=null;
        try{
            connect = JDBCUtils.getConnect();
            String sql="update student set name=?,age=?,sex=?,address=? where id=?";
            ps = connect.prepareStatement(sql);
            ps.setString(1,student.getName());
            ps.setInt(2,student.getAge());
            ps.setString(3,student.getSex());
            ps.setString(4,student.getAddress());
            ps.setInt(5,no);
            int i = ps.executeUpdate();
            return i;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            JDBCUtils.close(connect,null,ps);
        }
    }

    public Student selectStudentById(int id){
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            connection=JDBCUtils.getConnect();
            String sql="select * from student where id=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            Student student = new Student();
            while (rs.next()){
               int no = rs.getInt(1);
               String name=rs.getString(2);
               int age=rs.getInt(3);
               String sex=rs.getString(4);
               String address=rs.getString(5);
               student.setId(no);
               student.setName(name);
               student.setAge(age);
               student.setSex(sex);
               student.setAddress(address);
            }
            return student;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtils.close(connection,rs,ps);
        }

    }
   public int insertStudent(Student student){
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection=JDBCUtils.getConnect();
            String sql="insert into student(name,age,sex,address) value (?,?,?,?)";
            ps=connection.prepareStatement(sql);
            ps.setString(1,student.getName());
            ps.setInt(2,student.getAge());
            ps.setString(3,student.getSex());
            ps.setString(4,student.getAddress());
            boolean execute = ps.execute();
            if(execute){
                return 1;
            }else {
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            JDBCUtils.close(connection,null,ps);
        }
   }
   public int deleteStudentById(int id){
        Connection connection=null;
        PreparedStatement ps=null;
        try{
            connection=JDBCUtils.getConnect();
            String sql="delete from student where id=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            int i = ps.executeUpdate();
            return i;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            JDBCUtils.close(connection,null,ps);
        }
   }
}
