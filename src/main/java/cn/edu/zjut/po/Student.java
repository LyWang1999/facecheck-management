package cn.edu.zjut.po;

public class Student {
    private Integer stuID;
    private String name;
    private Integer sex;
    private String password;
    private String clazz;
    private String depart;
    private String email;
    private String img;

    public Student() {
        this.password = "123456";//设定初始密码
    }

    public Student(Integer stuID, String name, Integer sex, String password, String clazz, String depart, String email, String img) {
        this.stuID = stuID;
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.clazz = clazz;
        this.depart = depart;
        this.email = email;
        this.img = img;
    }

    public Integer getStuID() {
        return stuID;
    }

    public void setStuID(Integer stuID) {
        this.stuID = stuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
