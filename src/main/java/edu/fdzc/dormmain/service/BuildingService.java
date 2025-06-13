package edu.fdzc.dormmain.service;

import edu.fdzc.dormmain.entity.Building;
import java.util.List;

public interface BuildingService {

    List<Building> getAllBuildings();

    Building getBuildingById(String id);

    List<Building> getBuildingsByType(String type);

    int addBuilding(Building building);

    int updateBuilding(Building building);

    int deleteBuilding(String id);
}