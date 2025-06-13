package edu.fdzc.dormmain.mapper;

import edu.fdzc.dormmain.entity.Dormitory;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DormitoryMapper {

    // 查询所有宿舍
    @Select("SELECT id, building_id, floor, max_number, lived_number FROM dormitory")
    List<Dormitory> selectAll();

    // 根据楼栋ID查询宿舍
    @Select("SELECT id, building_id, floor, max_number, lived_number " +
            "FROM dormitory WHERE building_id = #{buildingId}")
    List<Dormitory> selectByBuildingId(@Param("buildingId") String buildingId);

    // 根据ID查询单个宿舍
    @Select("SELECT id, building_id, floor, max_number, lived_number " +
            "FROM dormitory WHERE id = #{id}")
    Dormitory selectById(@Param("id") String id);

    // 新增宿舍
    @Insert("INSERT INTO dormitory(id, building_id, floor, max_number, lived_number) " +
            "VALUES(#{id}, #{buildingId}, #{floor}, #{maxNumber}, #{livedNumber})")
    int insert(Dormitory dormitory);

    // 更新宿舍信息
    @Update("UPDATE dormitory SET " +
            "building_id = #{buildingId}, " +
            "floor = #{floor}, " +
            "max_number = #{maxNumber}, " +
            "lived_number = #{livedNumber} " +
            "WHERE id = #{id}")
    int update(Dormitory dormitory);

    // 更新已住人数
    @Update("UPDATE dormitory SET lived_number = lived_number + 1 WHERE id = #{dormId}")
    int increaseLivedNumber(@Param("dormId") String dormId);

    // 删除宿舍
    @Delete("DELETE FROM dormitory WHERE id = #{id}")
    int delete(@Param("id") String id);

    // 查询可用宿舍(未住满)
    @Select("SELECT * FROM dormitory WHERE lived_number < max_number")
    List<Dormitory> selectAvailableDormitories();
}