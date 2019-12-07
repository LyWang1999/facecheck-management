package cn.edu.zjut.po;

import org.springframework.stereotype.Component;

@Component
public class Gift {
    int gift_id;
    String gift_name;
    String gift_descript;
    String gift_img;
    int gift_score;
    int gift_quantity;

    public int getGift_quantity() {
        return gift_quantity;
    }

    public void setGift_quantity(int gift_quantity) {
        this.gift_quantity = gift_quantity;
    }

    public Gift() {
        //this.gift_img = "http://www.duliu12.xin/face/";
    }

    public int getGift_id() {
        return gift_id;
    }

    public int getGift_score() {
        return gift_score;
    }

    public String getGift_descript() {
        return gift_descript;
    }

    public String getGift_name() {
        return gift_name;
    }

    public void setGift_id(int gift_id) {
        this.gift_id = gift_id;
    }

    public String getGift_img() {
        return gift_img;
    }

    public void setGift_name(String gift_name) {
        this.gift_name = gift_name;
    }

    public void setGift_descript(String gift_descript) {
        this.gift_descript = gift_descript;
    }

    public void setGift_img(String gift_img) {
        this.gift_img = gift_img;
    }

    public void setGift_score(int gift_score) {
        this.gift_score = gift_score;
    }
}
