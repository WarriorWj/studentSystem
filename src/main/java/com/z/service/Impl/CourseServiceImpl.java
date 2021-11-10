package com.z.service.Impl;

import com.z.dao.CourseDao;
import com.z.entity.Course;
import com.z.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao=new CourseDao();

    @Override
    public List<Course> getAllCourse() {
        return courseDao.selectAllCourse();
    }

    @Override
    public Course getCourseByName(String name) {
        return courseDao.selectByName(name);
    }

    @Override
    public void addCourse(Course course) {
        courseDao.insertCourse(course);
    }

    @Override
    public int removeCourse(int cno) {
        return courseDao.deleteCourse(cno);
    }

    @Override
    public int updateCourse(Course course, int no) {
        return courseDao.updateCourse(course,no);
    }
}
