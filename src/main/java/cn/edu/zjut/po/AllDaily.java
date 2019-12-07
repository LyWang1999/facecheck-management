package cn.edu.zjut.po;

import java.util.Date;

//总的打卡信息
public class AllDaily {
    private String dailyID;//打卡ID
    private String dailyName;//打卡名
    private boolean isValidate;//该打卡是否在有效期内
    private Date cal;//发布打卡的日期
    private String arrPerson;//发布人

    public AllDaily() {
        super();
        // TODO Auto-generated constructor stub
    }

    public AllDaily(String dailyID, String dailyName, boolean isValidate, Date cal, String arrPerson) {
        super();
        this.dailyID = dailyID;
        this.dailyName = dailyName;
        this.isValidate = isValidate;
        this.cal = cal;
        this.arrPerson = arrPerson;
    }

    public String getDailyID() {
        return dailyID;
    }

    public void setDailyID(String dailyID) {
        this.dailyID = dailyID;
    }

    public String getDailyName() {
        return dailyName;
    }

    public void setDailyName(String dailyName) {
        this.dailyName = dailyName;
    }

    public boolean getIsValidate() {
        return isValidate;
    }

    public void setIsValidate(boolean isValidate) {
        this.isValidate = isValidate;
    }

    public Date getCal() {
        return cal;
    }

    public void setCal(Date cal) {
        this.cal = cal;
    }

    public String getArrPerson() {
        return arrPerson;
    }

    public void setArrPerson(String arrPerson) {
        this.arrPerson = arrPerson;
    }

}
