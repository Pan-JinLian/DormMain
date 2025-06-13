package edu.fdzc.dormmain.service;

import edu.fdzc.dormmain.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(String id);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(String id);
    void updatePassword(String id, String newPassword);
    List<Student> getStudentsByDepartment(String department);
}