package cn.edu.zjut.service;

import cn.edu.zjut.po.Student;

import java.util.List;

public interface ISignInstanceService {

    public int insertSignInstance(String[] stu, String[] dates, int templateid, int chooseid);
    public List<Student> listAllStudents();
}
