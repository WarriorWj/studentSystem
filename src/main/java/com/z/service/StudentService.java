package com.z.service;

import com.z.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    int updateStudent(Student student,int no);
    Student getStudentById(int id);
    int addStudent(Student student);
    int removeStudent(int id);
}
