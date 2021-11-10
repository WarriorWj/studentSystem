package com.z.controller;

import com.z.entity.Student;
import com.z.service.Impl.StudentServiceImpl;
import com.z.service.StudentService;

import java.util.List;

public class StudentController {
    StudentService studentService =new StudentServiceImpl();

    public void getAllStudent(){
        List<Student> allStudent = studentService.getAllStudent();
        for (Student student : allStudent) {
            System.out.println(student);
        }
    }

    public void updateStudent(){
        Student student = new Student();
        student.setName("小三");
        student.setAge(20);
        student.setSex("女");
        student.setAddress("湖南长沙");
        studentService.updateStudent(student,6);
    }

    public void getStudentById(){
        System.out.println(studentService.getStudentById(6));
    }

    public void addStudent(){
        Student student = new Student();
        student.setName("王伟");
        student.setAge(90);
        student.setSex("女");
        student.setAddress("峡谷");
        studentService.addStudent(student);
    }

    public void removeStudent(){
        studentService.removeStudent(7);
    }
}
