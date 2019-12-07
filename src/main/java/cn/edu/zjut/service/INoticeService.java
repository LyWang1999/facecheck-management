package cn.edu.zjut.service;

import cn.edu.zjut.po.Notice;

public interface INoticeService {
    public boolean makeNotice(Notice notice);
    public boolean searchNotice(int teaID);
}
