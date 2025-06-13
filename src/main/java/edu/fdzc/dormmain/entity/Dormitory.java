package edu.fdzc.dormmain.entity;

public class Dormitory {
    String id;
    String buildingId;
    Integer floor;
    Integer maxNumber;
    Integer livedNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Integer getLivedNumber() {
        return livedNumber;
    }

    public void setLivedNumber(Integer livedNumber) {
        this.livedNumber = livedNumber;
    }
}
