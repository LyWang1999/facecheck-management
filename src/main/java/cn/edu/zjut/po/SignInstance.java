package cn.edu.zjut.po;

import java.sql.Time;
import java.util.Date;

/**
 * 签到实例
 */
public class SignInstance {


    private Integer signInstID;//签到实例id
    private Integer signID;//对应签到信息表id
    private Time startTime;//开始时间
    private Time endTime;//截止时间
    private String longitude;//签到地点经度
    private String latitude;//签到地点纬度
    private Integer radius;
    private String placeName;//签到地点名称
    private Date date;//签到日期

    public Integer getSignInstID() {
        return signInstID;
    }

    public void setSignInstID(Integer signInstID) {
        this.signInstID = signInstID;
    }

    public Integer getSignID() {
        return signID;
    }

    public void setSignID(Integer signID) {
        this.signID = signID;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
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

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SignInstance(Integer signID, Time startTime, Time endTime, String longitude, String latitude, Integer radius, String placeName, Date date) {
        this.signID = signID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.radius = radius;
        this.placeName = placeName;
        this.date = date;
    }

    public SignInstance(Integer signInstID, Integer signID, Time startTime, Time endTime, String longitude, String latitude, Integer radius, String placeName, Date date) {
        this.signInstID = signInstID;
        this.signID = signID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.radius = radius;
        this.placeName = placeName;
        this.date = date;
    }

    public SignInstance() {
    }


}