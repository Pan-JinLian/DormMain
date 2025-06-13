package edu.fdzc.dormmain.controller;

import edu.fdzc.dormmain.entity.Live;
import edu.fdzc.dormmain.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/live")
public class LiveController {

    @Autowired
    private LiveService liveService;

    // 获取所有住宿记录
    @GetMapping
    public List<Live> getAll() {
        return liveService.getAllLives();
    }

    // 获取特定住宿记录
    @GetMapping("/{id}")
    public Live getById(@PathVariable Integer id) {
        return liveService.getLiveById(id);
    }

    // 获取学生的住宿记录
    @GetMapping("/student/{studentId}")
    public List<Live> getByStudent(@PathVariable String studentId) {
        return liveService.getLivesByStudent(studentId);
    }

    // 获取宿舍的住宿记录
    @GetMapping("/dormitory/{dormitoryId}")
    public List<Live> getByDormitory(@PathVariable String dormitoryId) {
        return liveService.getLivesByDormitory(dormitoryId);
    }

    // 新增住宿记录
    @PostMapping
    public String add(@RequestBody Live live) {
        liveService.addLive(live);
        return "添加成功，住宿ID: " + live.getId();
    }

    // 更新住宿记录
    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody Live live) {
        live.setId(id);
        liveService.updateLive(live);
        return "更新成功";
    }

    // 删除住宿记录
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        liveService.deleteLive(id);
        return "删除成功";
    }

    // 修改住宿状态
    @PutMapping("/{id}/status/{status}")
    public String changeStatus(@PathVariable Integer id, @PathVariable Integer status) {
        liveService.changeStatus(id, status);
        return "状态更新成功";
    }
}