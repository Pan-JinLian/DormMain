package edu.fdzc.dormmain.service;

import edu.fdzc.dormmain.dto.StudentDTO;
import edu.fdzc.dormmain.entity.Student;
import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(String id);
    void addStudent(Student student);
    void updateStudent(Student student);
    void updatePassword(String id, String newPassword);
    void deleteStudent(String id);
    Student login(String id, String password); // 登录验证
}