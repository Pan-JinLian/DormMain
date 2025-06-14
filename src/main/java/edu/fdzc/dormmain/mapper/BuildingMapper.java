package edu.fdzc.dormmain.mapper;

import edu.fdzc.dormmain.entity.Building;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BuildingMapper {

    // 查询所有宿舍楼
    @Results({
            @Result(property = "managerId", column = "manager_id")
    })
    @Select("SELECT id, name, type, floors, rooms, manager_id FROM building")
    List<Building> selectAll();

    // 根据ID查询单个宿舍楼
    @Results({
            @Result(property = "managerId", column = "manager_id")
    })
    @Select("SELECT id, name, type, floors, rooms, manager_id FROM building WHERE id = #{id}")
    Building selectById(@Param("id") String id);

    // 新增宿舍楼
    @Insert("INSERT INTO building(id, name, type, floors, rooms, manager_id) " +
            "VALUES(#{id}, #{name}, #{type}, #{floors}, #{rooms}, #{managerId})")
    int insert(Building building);

    // 更新宿舍楼信息
    @Update("UPDATE building SET " +
            "name = #{name}, " +
            "type = #{type}, " +
            "floors = #{floors}, " +
            "rooms = #{rooms}, " +
            "manager_id = #{managerId} " +
            "WHERE id = #{id}")
    int update(Building building);

    // 删除宿舍楼
    @Delete("DELETE FROM building WHERE id = #{id}")
    int delete(@Param("id") String id);

    // 根据类型查询宿舍楼(男生/女生/混合)
    @Select("SELECT * FROM building WHERE type = #{type}")
    List<Building> selectByType(@Param("type") String type);
}