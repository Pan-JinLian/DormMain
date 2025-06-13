package edu.fdzc.dormmain.controller;

import edu.fdzc.dormmain.entity.Building;
import edu.fdzc.dormmain.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    // 获取所有宿舍楼
    @GetMapping
    public ResponseEntity<List<Building>> getAllBuildings() {
        List<Building> buildings = buildingService.getAllBuildings();
        return ResponseEntity.ok(buildings);
    }

    // 获取特定宿舍楼
    @GetMapping("/{id}")
    public ResponseEntity<Building> getBuildingById(@PathVariable String id) {
        Building building = buildingService.getBuildingById(id);
        return ResponseEntity.ok(building);
    }

    // 按类型查询宿舍楼
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Building>> getBuildingsByType(@PathVariable String type) {
        List<Building> buildings = buildingService.getBuildingsByType(type);
        return ResponseEntity.ok(buildings);
    }

    // 添加新宿舍楼
    @PostMapping
    public ResponseEntity<Building> addBuilding(@RequestBody Building building) {
        buildingService.addBuilding(building);
        return ResponseEntity.status(HttpStatus.CREATED).body(building);
    }

    // 更新宿舍楼信息
    @PutMapping("/{id}")
    public ResponseEntity<Building> updateBuilding(
            @PathVariable String id,
            @RequestBody Building building) {
        building.setId(id); // 确保ID一致
        buildingService.updateBuilding(building);
        return ResponseEntity.ok(building);
    }

    // 删除宿舍楼
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable String id) {
        buildingService.deleteBuilding(id);
        return ResponseEntity.noContent().build();
    }
}