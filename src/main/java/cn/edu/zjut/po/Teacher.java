package cn.edu.zjut.po;

public class Teacher {
    private Integer teaID;
    private String name;
    private String password;
    private Integer sex;
    private String phone;

    public Teacher() {
    }

    public Teacher(Integer teaID, String name, String password, Integer sex, String phone) {
        this.teaID = teaID;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
    }

    public Integer getTeaID() {
        return teaID;
    }

    public void setTeaID(Integer teaID) {
        this.teaID = teaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
