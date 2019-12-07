package cn.edu.zjut.po;

public class GiftChange {
    private StudentGift sg;
    private String gift_name;

    public void setGift_name(String gift_name) {
        this.gift_name = gift_name;
    }

    public String getGift_name() {
        return gift_name;
    }

    public StudentGift getSg() {
        return sg;
    }

    public void setSg(StudentGift sg) {
        this.sg = sg;
    }
}
