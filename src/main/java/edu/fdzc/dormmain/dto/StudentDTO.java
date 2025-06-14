package edu.fdzc.dormmain.dto;

import edu.fdzc.dormmain.entity.Student;
import lombok.Data;

@Data
public class StudentDTO {
    private String id;
    private String name;
    private String gender;
    private String department;
    private String phone;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.gender = student.getGender();
        this.department = student.getDepartment();
        this.phone = student.getPhone();
    }
}