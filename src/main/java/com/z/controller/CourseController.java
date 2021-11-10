package com.z.controller;

import com.z.entity.Course;
import com.z.service.CourseService;
import com.z.service.Impl.CourseServiceImpl;

import javax.servlet.http.HttpServlet;
import java.util.List;

public class CourseController{
    CourseService courseService=new CourseServiceImpl();

    public void getAllCourse(){
        List<Course> allCourse = courseService.getAllCourse();
        for (Course course : allCourse) {
            System.out.println(course);
        }
    }

    public void removeCourse(){
        int i = courseService.removeCourse(5);
        System.out.println(i);
    }

    public void updateCourse(){
        Course course = new Course();
        course.setCname("消费鬼轮");
        course.setCmark("消费类");
        courseService.updateCourse(course,5);
    }

    public void addCourse(){
        Course course = new Course();
        course.setCname("aaa");
        course.setCmark("aaa");
        courseService.addCourse(course);
    }

    public void getCourseByCname(){
        Course course = courseService.getCourseByName("SQL");
        System.out.println(course);

    }
}
