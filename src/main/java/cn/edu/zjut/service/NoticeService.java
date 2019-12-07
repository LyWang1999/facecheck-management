package cn.edu.zjut.service;

import cn.edu.zjut.dao.NoticeMapper;
import cn.edu.zjut.dao.StudentMapper;
import cn.edu.zjut.po.Notice;
import cn.edu.zjut.po.Student;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

@Service
public class NoticeService implements  INoticeService {
    private Map<String, Object> request, session;
    @Autowired
    NoticeMapper noticeMapper;
    @Autowired
    StudentMapper studentMapper;

    public void setNoticeMapper(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public NoticeMapper noticeMapper() {
        return noticeMapper;
    }

    public boolean makeNotice(Notice notice) {
        try {

            notice.setDate(new Date());
            notice.incre();
            noticeMapper.insertNotice(notice);
            int id=noticeMapper.selectMaxId();
            ArrayList<Student> stu = (ArrayList<Student>) studentMapper.listAllStudent();
            ArrayList<Notice> notices = new ArrayList<Notice>();
            for (Iterator it = stu.iterator(); it.hasNext(); ) {
                Notice notice1 = new Notice();
                notice1.setStuID(((Student) it.next()).getStuID());
                String ins=studentMapper.getOpenid(notice1.getStuID());

                if(ins==null)
                notice1.setOpenid("noid");
                else
                    notice1.setOpenid(ins);
                notice1.setDate(notice.getDate());
                notice1.setNoticeID(id);
                notices.add(notice1);
            }
            noticeMapper.insertStuNotice(notices);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean searchNotice(int teaID){
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        session = (Map) ctx.getSession();
        try{
            ArrayList<Notice>noticeList=noticeMapper.selectNotice(teaID);

            for(Iterator<Notice>it=noticeList.iterator();it.hasNext();){
                System.out.println(it.next().getContent());
            }
            session.put("noticeList",noticeList);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
