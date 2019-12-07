package cn.edu.zjut.dao;

import cn.edu.zjut.po.Notice;

import java.util.ArrayList;

public interface NoticeMapper {
 public void insertNotice(Notice notice);
 public void insertStuNotice(ArrayList<Notice> list);
 public int selectMaxId();
 public ArrayList<Notice>selectNotice(int teaID);
}
