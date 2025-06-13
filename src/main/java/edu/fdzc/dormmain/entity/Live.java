package edu.fdzc.dormmain.entity;

import java.util.Date;

public class Live {
    Integer id;
    String studentId;
    String dormitoryId;
    String bedId;
    Date liveInDate;
    Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public Date getLiveInDate() {
        return liveInDate;
    }

    public void setLiveInDate(Date liveInDate) {
        this.liveInDate = liveInDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
