package edu.fdzc.dormmain.service.impl;

import edu.fdzc.dormmain.dto.StudentDTO;
import edu.fdzc.dormmain.entity.Student;
import edu.fdzc.dormmain.mapper.StudentMapper;
import edu.fdzc.dormmain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentMapper.selectAll().stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(String id) {
        Student student = studentMapper.selectById(id);
        return student != null ? new StudentDTO(student) : null;
    }

    @Override
    public void addStudent(Student student) {
        // 暂时不加密密码
        studentMapper.insert(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void updatePassword(String id, String newPassword) {
        // 暂时不加密密码
        studentMapper.updatePassword(id, newPassword);
    }

    @Override
    public void deleteStudent(String id) {
        studentMapper.delete(id);
    }

    @Override
    public Student login(String id, String password) {
        Student student = studentMapper.selectByIdWithPassword(id);
        // 简单比较密码（明文）
        if (student != null && password.equals(student.getPassword())) {
            return student;
        }
        return null;
    }
}