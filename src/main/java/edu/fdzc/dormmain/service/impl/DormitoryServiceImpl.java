package edu.fdzc.dormmain.service.impl;

import edu.fdzc.dormmain.entity.Dormitory;
import edu.fdzc.dormmain.mapper.DormitoryMapper;
import edu.fdzc.dormmain.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List<Dormitory> getAllDormitories() {
        return dormitoryMapper.selectAll();
    }

    @Override
    public Dormitory getDormitoryById(String id) {
        return dormitoryMapper.selectById(id);
    }

    @Override
    public List<Dormitory> getDormitoriesByBuilding(String buildingId) {
        return dormitoryMapper.selectByBuildingId(buildingId);
    }

    @Override
    public List<Dormitory> getAvailableDormitories() {
        return dormitoryMapper.selectAvailableDormitories();
    }

    @Override
    public int addDormitory(Dormitory dormitory) {
        // 可以添加业务逻辑验证
        if (dormitory.getMaxNumber() <= 0) {
            throw new IllegalArgumentException("床位数量必须大于0");
        }
        return dormitoryMapper.insert(dormitory);
    }

    @Override
    public int updateDormitory(Dormitory dormitory) {
        return dormitoryMapper.update(dormitory);
    }

    @Override
    public int deleteDormitory(String id) {
        return dormitoryMapper.delete(id);
    }

    @Override
    public int allocateStudent(String dormitoryId) {
        // 检查宿舍是否已满
        Dormitory dorm = dormitoryMapper.selectById(dormitoryId);
        if (dorm.getLivedNumber() >= dorm.getMaxNumber()) {
            throw new IllegalStateException("该宿舍已满员");
        }
        return dormitoryMapper.increaseLivedNumber(dormitoryId);
    }
}