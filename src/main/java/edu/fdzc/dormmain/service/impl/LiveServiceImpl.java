package edu.fdzc.dormmain.service.impl;

import edu.fdzc.dormmain.entity.Live;
import edu.fdzc.dormmain.mapper.LiveMapper;
import edu.fdzc.dormmain.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class LiveServiceImpl implements LiveService {

    @Autowired
    private LiveMapper liveMapper;

    @Override
    public List<Live> getAllLives() {
        return liveMapper.selectAll();
    }

    @Override
    public Live getLiveById(Integer id) {
        return liveMapper.selectById(id);
    }

    @Override
    public List<Live> getLivesByStudent(String studentId) {
        return liveMapper.selectByStudentId(studentId);
    }

    @Override
    public List<Live> getLivesByDormitory(String dormitoryId) {
        return liveMapper.selectByDormitoryId(dormitoryId);
    }

    @Override
    @Transactional
    public int addLive(Live live) {
        // 设置入住日期为当前时间
        live.setLiveInDate(new Date());
        // 默认状态为1(正常)
        live.setStatus(1);
        return liveMapper.insert(live);
    }

    @Override
    @Transactional
    public int updateLive(Live live) {
        return liveMapper.update(live);
    }

    @Override
    @Transactional
    public int deleteLive(Integer id) {
        return liveMapper.delete(id);
    }

    @Override
    @Transactional
    public int changeStatus(Integer id, Integer status) {
        if (status < 0 || status > 2) {
            throw new IllegalArgumentException("状态值不合法 (0-退宿, 1-正常, 2-调宿中)");
        }
        return liveMapper.updateStatus(id, status);
    }
}