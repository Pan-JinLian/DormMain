package edu.fdzc.dormmain.service;

import edu.fdzc.dormmain.entity.Dormitory;
import java.util.List;

public interface DormitoryService {

    List<Dormitory> getAllDormitories();

    Dormitory getDormitoryById(String id);

    List<Dormitory> getDormitoriesByBuilding(String buildingId);

    List<Dormitory> getAvailableDormitories();

    int addDormitory(Dormitory dormitory);

    int updateDormitory(Dormitory dormitory);

    int deleteDormitory(String id);

    int allocateStudent(String dormitoryId);
}