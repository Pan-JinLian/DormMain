package edu.fdzc.dormmain.controller;

import edu.fdzc.dormmain.dto.StudentDTO;
import edu.fdzc.dormmain.entity.Student;
import edu.fdzc.dormmain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 获取所有学生
    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    // 获取单个学生
    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    // 添加学生
    @PostMapping
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "添加成功";
    }

    // 更新学生信息
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable String id, @RequestBody Student student) {
        student.setId(id);
        studentService.updateStudent(student);
        return "更新成功";
    }

    // 修改密码（暂时使用明文）
    @PutMapping("/{id}/password")
    public String updatePassword(@PathVariable String id, @RequestBody String newPassword) {
        studentService.updatePassword(id, newPassword);
        return "密码修改成功";
    }

    // 删除学生
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return "删除成功";
    }

    // 登录接口（简单验证）
    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String password) {
        Student student = studentService.login(id, password);
        return student != null ? "登录成功" : "学号或密码错误";
    }
}