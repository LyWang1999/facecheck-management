package cn.edu.zjut.po;

public class StudentGift {
    int autoid;
    int student_id;
    int gift_id;
    boolean result;
    int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setGift_id(int gift_id) {
        this.gift_id = gift_id;
    }

    public int getAutoid() {
        return autoid;
    }

    public int getGift_id() {
        return gift_id;
    }

    public boolean getResult() {
        return result;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
