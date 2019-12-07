package cn.edu.zjut.dao;

import cn.edu.zjut.po.SignInstanceTemplate;

import java.util.List;

public interface TemplateMapper {

    public int insertTemplate(SignInstanceTemplate signTemplate) throws Exception;

    public List<SignInstanceTemplate> getTemplateByTid(int teaID) throws Exception;

    public SignInstanceTemplate getTemplateByid(int templateid) throws Exception;

    public int DeleteTemplate(int templateid) throws Exception;
}
