package com.z.service;

import com.z.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    Course getCourseByName(String name);
    void addCourse(Course course);
    int removeCourse(int cno);
    int updateCourse(Course course,int no);
}
