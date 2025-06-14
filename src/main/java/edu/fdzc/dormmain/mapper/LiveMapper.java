package edu.fdzc.dormmain.mapper;

import edu.fdzc.dormmain.entity.Live;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LiveMapper {

    // 查询所有住宿记录
    @Results({
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "dormitoryId", column = "dormitory_id"),
            @Result(property = "bedId", column = "bed_id"),
            @Result(property = "liveInDate", column = "live_in_date")
    })
    @Select("SELECT * FROM live")
    List<Live> selectAll();

    // 根据ID查询住宿记录
    @Results({
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "dormitoryId", column = "dormitory_id"),
            @Result(property = "bedId", column = "bed_id"),
            @Result(property = "liveInDate", column = "live_in_date")
    })
    @Select("SELECT * FROM live WHERE id = #{id}")
    Live selectById(@Param("id") Integer id);

    // 根据学生ID查询住宿记录
    @Results({
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "dormitoryId", column = "dormitory_id"),
            @Result(property = "bedId", column = "bed_id"),
            @Result(property = "liveInDate", column = "live_in_date")
    })
    @Select("SELECT * FROM live WHERE student_id = #{studentId}")
    List<Live> selectByStudentId(@Param("studentId") String studentId);

    // 根据宿舍ID查询住宿记录
    @Results({
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "dormitoryId", column = "dormitory_id"),
            @Result(property = "bedId", column = "bed_id"),
            @Result(property = "liveInDate", column = "live_in_date")
    })
    @Select("SELECT * FROM live WHERE dormitory_id = #{dormitoryId}")
    List<Live> selectByDormitoryId(@Param("dormitoryId") String dormitoryId);

    // 新增住宿记录
    @Insert("INSERT INTO live(student_id, dormitory_id, bed_id, live_in_date, status) " +
            "VALUES(#{studentId}, #{dormitoryId}, #{bedId}, #{liveInDate}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Live live);

    // 更新住宿记录
    @Update("UPDATE live SET " +
            "student_id = #{studentId}, " +
            "dormitory_id = #{dormitoryId}, " +
            "bed_id = #{bedId}, " +
            "live_in_date = #{liveInDate}, " +
            "status = #{status} " +
            "WHERE id = #{id}")
    int update(Live live);

    // 删除住宿记录
    @Delete("DELETE FROM live WHERE id = #{id}")
    int delete(@Param("id") Integer id);

    // 更新住宿状态
    @Update("UPDATE live SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") Integer id, @Param("status") Integer status);
}