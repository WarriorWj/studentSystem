package com.z.service.Impl;

import com.z.dao.StudentDao;
import com.z.entity.Student;
import com.z.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
   StudentDao studentDao = new StudentDao();

   @Override
   public List<Student> getAllStudent(){
      List<Student> students = studentDao.selectAllStudent();
      return students;
   }

   @Override
   public int updateStudent(Student student, int no) {
      int i = studentDao.updateStudent(student, no);
      return i;
   }

   @Override
   public Student getStudentById(int id) {
      return studentDao.selectStudentById(id);
   }

   @Override
   public int addStudent(Student student) {

      return studentDao.insertStudent(student);
   }

   @Override
   public int removeStudent(int id) {
      return studentDao.deleteStudentById(id);
   }
}
