package cn.edu.zjut.po;

import java.util.List;

public class TaskList {

    private Integer teaID;
    private List<Sign> signs;
    private List<SignInstanceTemplate> templates;

    public TaskList() {
    }

    public Integer getTeaID() {
        return teaID;
    }

    public void setTeaID(Integer teaID) {
        this.teaID = teaID;
    }

    public List<Sign> getSigns() {
        return signs;
    }

    public void setSigns(List<Sign> signs) {
        this.signs = signs;
    }

    public List<SignInstanceTemplate> getTemplates() {
        return templates;
    }

    public void setTemplates(List<SignInstanceTemplate> templates) {
        this.templates = templates;
    }

    public TaskList(Integer teaID, List<Sign> signs, List<SignInstanceTemplate> templates) {
        this.teaID = teaID;
        this.signs = signs;
        this.templates = templates;
    }
}
