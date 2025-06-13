package edu.fdzc.dormmain.service;

import edu.fdzc.dormmain.entity.Live;
import java.util.List;

public interface LiveService {
    List<Live> getAllLives();
    Live getLiveById(Integer id);
    List<Live> getLivesByStudent(String studentId);
    List<Live> getLivesByDormitory(String dormitoryId);
    int addLive(Live live);
    int updateLive(Live live);
    int deleteLive(Integer id);
    int changeStatus(Integer id, Integer status);
}