package edu.fdzc.dormmain.service.impl;

import edu.fdzc.dormmain.entity.Building;
import edu.fdzc.dormmain.mapper.BuildingMapper;
import edu.fdzc.dormmain.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<Building> getAllBuildings() {
        return buildingMapper.selectAll();
    }

    @Override
    public Building getBuildingById(String id) {
        return buildingMapper.selectById(id);
    }

    @Override
    public List<Building> getBuildingsByType(String type) {
        if (!"男生".equals(type) && !"女生".equals(type) && !"混合".equals(type)) {
            throw new IllegalArgumentException("楼栋类型必须是'男生'、'女生'或'混合'");
        }
        return buildingMapper.selectByType(type);
    }

    @Override
    public int addBuilding(Building building) {
        // 验证楼层和房间数必须大于0
        if (building.getFloors() == null || building.getFloors() <= 0) {
            throw new IllegalArgumentException("楼层数必须大于0");
        }
        if (building.getRooms() == null || building.getRooms() <= 0) {
            throw new IllegalArgumentException("房间数必须大于0");
        }
        return buildingMapper.insert(building);
    }

    @Override
    public int updateBuilding(Building building) {
        // 更新前检查是否存在
        Building existing = buildingMapper.selectById(building.getId());
        if (existing == null) {
            throw new IllegalArgumentException("宿舍楼不存在");
        }
        return buildingMapper.update(building);
    }

    @Override
    public int deleteBuilding(String id) {
        // 删除前可以添加业务逻辑，如检查是否有宿舍关联等
        return buildingMapper.delete(id);
    }
}