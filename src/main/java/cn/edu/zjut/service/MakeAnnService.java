package cn.edu.zjut.service;

import cn.edu.zjut.dao.StudentMapper;
import cn.edu.zjut.po.Announcement;
import cn.edu.zjut.po.Student;

import java.util.ArrayList;
import java.util.Iterator;

public class MakeAnnService implements IMakeAnnService {
    //@Autowired
   // private AnnouncementMapper announcementMapper;
   // @Autowired
    private StudentMapper studentMapper;
    public  boolean makeAnn(Announcement announcement){
        try {
            ArrayList<Student> students = (ArrayList<Student>) studentMapper.listAllStudent();
            for (Iterable<Student> stuIt = (Iterable<Student>) students.iterator(); ((Iterator) stuIt).hasNext(); ) {
                Announcement announcement1 = new Announcement();
                announcement1.setTeacher(announcement.getTeacher());
                announcement1.setDescribe(announcement.getDescribe());
                announcement1.setTitle(announcement.getTitle());
                announcement1.setStudent((Student) ((Iterator) stuIt).next());
                //announcementMapper.insertAnn(announcement1);
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }return  false;
    }
}
