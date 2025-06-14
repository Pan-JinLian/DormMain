package edu.fdzc.dormmain.mapper;

import edu.fdzc.dormmain.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    // 查询所有学生(不包含密码)
    @Select("SELECT id, name, gender, department, phone FROM student")
    List<Student> selectAll();

    // 根据ID查询学生(包含密码，用于登录验证)
    @Select("SELECT id, name, password, gender, department, phone FROM student WHERE id = #{id}")
    Student selectByIdWithPassword(@Param("id") String id);

    // 根据ID查询学生(不包含密码)
    @Select("SELECT id, name, gender, department, phone FROM student WHERE id = #{id}")
    Student selectById(@Param("id") String id);

    // 插入学生
    @Insert("INSERT INTO student(id, name, password, gender, department, phone) " +
            "VALUES(#{id}, #{name}, #{password}, #{gender}, #{department}, #{phone})")
    int insert(Student student);

    // 更新学生信息(不更新密码)
    @Update("UPDATE student SET " +
            "name = #{name}, " +
            "gender = #{gender}, " +
            "department = #{department}, " +
            "phone = #{phone} " +
            "WHERE id = #{id}")
    int update(Student student);

    // 更新密码
    @Update("UPDATE student SET password = #{password} WHERE id = #{id}")
    int updatePassword(@Param("id") String id, @Param("password") String password);

    // 删除学生
    @Delete("DELETE FROM student WHERE id = #{id}")
    int delete(@Param("id") String id);
}