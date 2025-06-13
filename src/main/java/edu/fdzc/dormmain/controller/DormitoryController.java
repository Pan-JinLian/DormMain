package edu.fdzc.dormmain.controller;

import edu.fdzc.dormmain.entity.Dormitory;
import edu.fdzc.dormmain.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dorm")  // 简化路径
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    // 1. 查所有宿舍（GET /dorm）
    @GetMapping
    public List<Dormitory> getAll() {
        return dormitoryService.getAllDormitories();
    }

    // 2. 查单个宿舍（GET /dorm/101）
    @GetMapping("/{id}")
    public Dormitory getById(@PathVariable String id) {
        return dormitoryService.getDormitoryById(id);
    }

    // 3. 添加宿舍（POST /dorm）
    @PostMapping
    public String add(@RequestBody Dormitory dorm) {
        dormitoryService.addDormitory(dorm);
        return "添加成功"; // 直接返回字符串
    }

    // 4. 修改宿舍（PUT /dorm/101）
    @PutMapping("/{id}")
    public String update(@PathVariable String id, @RequestBody Dormitory dorm) {
        dorm.setId(id);
        dormitoryService.updateDormitory(dorm);
        return "修改成功";
    }

    // 5. 删除宿舍（DELETE /dorm/101）
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        dormitoryService.deleteDormitory(id);
        return "删除成功";
    }
}