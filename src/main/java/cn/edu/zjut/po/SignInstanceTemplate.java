package cn.edu.zjut.po;

import java.sql.Time;
import java.util.Date;

/**
 * 签到实例模板
 */
public class SignInstanceTemplate {
    private Integer tempID;//签到实例模板ID
    private Integer teaID;//教师ID（模板的拥有者）
    private Time startTime;//签到开始时间
    private int radius;
    private Time endTime;//签到截止时间
    private String longitude;//签到地点经度
    private String latitude;//签到地点纬度
    private String placeName;//签到地点名称

    public SignInstanceTemplate(Integer tempID, Integer teaID, Time startTime, int radius, Time endTime, String longitude, String latitude, String placeName) {
        this.tempID = tempID;
        this.teaID = teaID;
        this.startTime = startTime;
        this.radius = radius;
        this.endTime = endTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.placeName = placeName;
    }

    public Integer getTempID() {
        return tempID;
    }

    public void setTempID(Integer tempID) {
        this.tempID = tempID;
    }

    public Integer getTeaID() {
        return teaID;
    }

    public void setTeaID(Integer teaID) {
        this.teaID = teaID;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public SignInstanceTemplate() {
    }

}