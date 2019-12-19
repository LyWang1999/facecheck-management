package cn.edu.zjut.po;



public class Suggest {
    private String name;
    private String suggest;
    private String time;

    public Suggest() {
    }

    public Suggest(String name, String suggest, String time) {
        this.name = name;
        this.suggest = suggest;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

