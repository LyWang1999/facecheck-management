package cn.edu.zjut.po;

import java.util.Date;

/**
 * 签到
 */
public class Sign {
    private Integer signID;//签到ID
    private String name;//签到名称
    private String description;//签到描述
    private Date createTime;//创建时间
    private Integer teaID;//教师ID（签到的创建者）

    public Sign() {
    }

    public Sign(Integer signID, String name, String description, Date createTime, Integer teaID) {
        this.signID = signID;
        this.name = name;
        this.description = description;
        this.createTime = createTime;
        this.teaID = teaID;
    }

    public Integer getSignID() {
        return signID;
    }

    public void setSignID(Integer signID) {
        this.signID = signID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTeaID() {
        return teaID;
    }

    public void setTeaID(Integer teaID) {
        this.teaID = teaID;
    }
}
