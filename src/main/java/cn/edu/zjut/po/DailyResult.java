package cn.edu.zjut.po;

public class DailyResult {
    SignInstance signinstance;
    String sign_name;
    int all;
    int fact;

    public void setSigninstance(SignInstance signinstance) {
        this.signinstance = signinstance;
    }

    public SignInstance getSigninstance() {
        return signinstance;
    }

    public void setSign_name(String sign_name) {
        this.sign_name = sign_name;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public int getAll() {
        return all;
    }

    public void setFact(int fact) {
        this.fact = fact;
    }

    public int getFact() {
        return fact;
    }

    public String getSign_name() {
        return sign_name;
    }

}
