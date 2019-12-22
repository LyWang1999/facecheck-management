package cn.edu.zjut.po;

import java.util.Date;

/**
 * 学生签到结果表
 */
public class StudentSign {
    private Integer stuSignID;//结果ID,数据库中自动增加
    private Integer stuID;//学生学号
    private Integer signInstID;//签到实例id
    private Date signTime;//签到时间
    private String signImgUrl;//签到照片URL
    private String stuEmail;//学生邮箱
    private String stuImgUrl;//学生注册照片URL
    private double similar;//识别的相似度
    private Integer status;//签到状态(0:未签到,1:签到成功,2:请假)

    public StudentSign() {
    }

    public StudentSign(Integer stuSignID, Integer stuID, Integer signInstID, Date signTime, String signImgUrl, String stuEmail, String stuImgUrl, double similar, Integer status) {
        this.stuSignID = stuSignID;
        this.stuID = stuID;
        this.signInstID = signInstID;
        this.signTime = signTime;
        this.signImgUrl = signImgUrl;
        this.stuEmail = stuEmail;
        this.stuImgUrl = stuImgUrl;
        this.similar = similar;
        this.status = status;
    }

    public Integer getStuSignID() {
        return stuSignID;
    }

    public void setStuSignID(Integer stuSignID) {
        this.stuSignID = stuSignID;
    }

    public Integer getStuID() {
        return stuID;
    }

    public void setStuID(Integer stuID) {
        this.stuID = stuID;
    }

    public Integer getSignInstID() {
        return signInstID;
    }

    public void setSignInstID(Integer signInstID) {
        this.signInstID = signInstID;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getSignImgUrl() {
        return signImgUrl;
    }

    public void setSignImgUrl(String signImgUrl) {
        this.signImgUrl = signImgUrl;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuImgUrl() {
        return stuImgUrl;
    }

    public void setStuImgUrl(String stuImgUrl) {
        this.stuImgUrl = stuImgUrl;
    }

    public double getSimilar() {
        return similar;
    }

    public void setSimilar(double similar) {
        this.similar = similar;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentSign{" +
                "stuSignID=" + stuSignID +
                ", stuID=" + stuID +
                ", signInstID=" + signInstID +
                ", signTime=" + signTime +
                ", signImgUrl='" + signImgUrl + '\'' +
                ", stuEmail='" + stuEmail + '\'' +
                ", stuImgUrl='" + stuImgUrl + '\'' +
                ", similar=" + similar +
                ", status=" + status +
                '}';
    }
}
