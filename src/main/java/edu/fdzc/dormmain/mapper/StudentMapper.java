package edu.fdzc.dormmain.mapper;

import edu.fdzc.dormmain.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    // 查询所有学生（带分页参数示例）
    @Select("SELECT id, name, gender, department, phone FROM student")
    List<Student> selectAll();

    // 根据ID查询学生（明确指定返回字段）
    @Select("SELECT id, name, password, gender, department, phone FROM student WHERE id = #{id}")
    Student selectById(@Param("id") String id);

    // 插入学生（使用useGeneratedKeys获取自增ID，如果id是自增的话）
    @Insert("INSERT INTO student(id, name, password, gender, department, phone) " +
            "VALUES(#{id}, #{name}, #{password}, #{gender}, #{department}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Student student);

    // 更新学生所有信息（密码单独处理）
    @Update("<script>" +
            "UPDATE student " +
            "<set>" +
            "   <if test='name != null'>name=#{name},</if>" +
            "   <if test='gender != null'>gender=#{gender},</if>" +
            "   <if test='department != null'>department=#{department},</if>" +
            "   <if test='phone != null'>phone=#{phone}</if>" +
            "</set>" +
            "WHERE id=#{id}" +
            "</script>")
    int update(Student student);

    // 单独更新密码的方法
    @Update("UPDATE student SET password=#{password} WHERE id=#{id}")
    int updatePassword(@Param("id") String id, @Param("password") String password);

    // 删除学生
    @Delete("DELETE FROM student WHERE id = #{id}")
    int delete(@Param("id") String id);

    // 按条件查询（示例：按院系查询）
    @Select("<script>" +
            "SELECT id, name, gender, department, phone FROM student " +
            "<where>" +
            "   <if test='department != null'>AND department=#{department}</if>" +
            "   <if test='gender != null'>AND gender=#{gender}</if>" +
            "</where>" +
            "</script>")
    List<Student> selectByCondition(@Param("department") String department,
                                    @Param("gender") String gender);
}