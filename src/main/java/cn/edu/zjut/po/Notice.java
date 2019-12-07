package cn.edu.zjut.po;

import java.util.Date;

public class Notice {
    private  int teaID;
    static  private  int  noticeID=1;
    private  int stuID;
    private String title;
    private  String content;
    private Date date;
    private String openid;

    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public String getOpenid(){
        return  openid;
    }

    public void setTeaID(int teaID){
        this.teaID=teaID;
    }

    public int getTeaID() {
        return teaID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public int getStuID() {
        return stuID;
    }
    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content){
        this.content=content;
    }
    public String getContent(){
        return content;
    }
    public void setDate(Date date){
        this.date=date;
    }
    public Date getDate(){
        return date;
    }
    public  int getNoticeID(){
        return  noticeID;
    }

    public void setNoticeID(int noticeID) {
        this.noticeID = noticeID;
    }
    public void incre(){
        noticeID++;
    }
}
