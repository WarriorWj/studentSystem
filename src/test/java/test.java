import com.z.controller.CourseController;
import com.z.controller.StudentController;
import com.z.controller.UserController;
import com.z.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class test {
    UserController userController = new UserController();
    StudentController studentController=new StudentController();
    CourseController courseController= new CourseController();
    @Test
    public void testConnect(){
        Connection connect = JDBCUtils.getConnect();
        System.out.println(connect);
    }



    @Test
    public void testGetAllUser(){
        userController.getAllUser();
    }
    @Test
    public void updateUserByNo() {
        userController.updateUser();
    }
    @Test
    public void insertUser() {
        userController.addUser();
    }
    @Test
    public void removeUser() {
        userController.removeUser();
    }
    @Test
    public void getUserByName(){
        userController.getUserByName();
    }




    @Test
    public void getStudent(){
        studentController.getAllStudent();
    }
    @Test
    public void updateStudent(){
        studentController.updateStudent();
    }
    @Test
    public void getStudentById(){
        studentController.getStudentById();
    }
    @Test
    public void addStudent(){
        studentController.addStudent();
    }
    @Test
    public void deleteStudentById(){
        studentController.removeStudent();
    }



    @Test
    public void addCourse(){
        courseController.addCourse();
    }
    @Test
    public void getAllCourse(){
        courseController.getAllCourse();
    }
    @Test
    public void updateCourse(){
        courseController.updateCourse();
    }
    @Test
    public void deleteCourse(){
        courseController.removeCourse();
    }
    @Test
    public void getCourseByName(){
        courseController.getCourseByCname();
    }

}
