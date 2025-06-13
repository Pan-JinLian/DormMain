package edu.fdzc.dormmain.service.impl;

import edu.fdzc.dormmain.entity.Student;
import edu.fdzc.dormmain.mapper.StudentMapper;
import edu.fdzc.dormmain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }

    @Override
    public Student getStudentById(String id) {
        return studentMapper.selectById(id);
    }

    @Override
    public void addStudent(Student student) {
        // 这里可以添加密码加密逻辑
        studentMapper.insert(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void updatePassword(String id, String newPassword) {
        // 密码加密后再存储
        String encryptedPwd = encryptPassword(newPassword);
        studentMapper.updatePassword(id, encryptedPwd);
    }

    @Override
    public void deleteStudent(String id) {
        studentMapper.delete(id);
    }

    @Override
    public List<Student> getStudentsByDepartment(String department) {
        return studentMapper.selectByCondition(department, null);
    }

    private String encryptPassword(String rawPassword) {
        // 实现密码加密逻辑
        return rawPassword; // 实际项目请替换为BCrypt等加密
    }
}