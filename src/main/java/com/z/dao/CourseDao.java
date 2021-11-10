package com.z.dao;

import com.z.entity.Course;
import com.z.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    public List<Course> selectAllCourse(){
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql="select * from course";
            connection=JDBCUtils.getConnect();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            List<Course> courseList=new ArrayList<>();
            while (rs.next()){
                Course course = new Course();
                course.setCno(rs.getInt(1));
                course.setCname(rs.getString(2));
                course.setCmark(rs.getString(3));
                courseList.add(course);
            }
            return courseList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtils.close(connection,rs,ps);
        }
    }

    public void insertCourse(Course course){
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection=JDBCUtils.getConnect();
            String sql="insert into course(cname,cmark) value (?,?) ";
            ps=connection.prepareStatement(sql);
            ps.setString(1,course.getCname());
            ps.setString(2,course.getCmark());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,null,ps);
        }
    }

    public int updateCourse(Course course,int id){
        Connection connection=null;
        PreparedStatement ps=null;
        try{
            connection=JDBCUtils.getConnect();
            String sql="update course set cname=?,cmark=? where cno =?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,course.getCname());
            ps.setString(2,course.getCmark());
            ps.setInt(3,id);
            int i = ps.executeUpdate();
            return i;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            JDBCUtils.close(connection,null,ps);
        }
    }

    public Course selectByName(String name){
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql="select * from course where cname=?";
            connection=JDBCUtils.getConnect();
            ps=connection.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            Course course = new Course();
            while (rs.next()){
                course.setCno(rs.getInt(1));
                course.setCname(rs.getString(2));
                course.setCmark(rs.getString(3));
            }
            return course;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtils.close(connection,rs,ps);
        }
    }


    public int deleteCourse(int no){
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection=JDBCUtils.getConnect();
            String sql="delete from course where cno=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,no);
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
