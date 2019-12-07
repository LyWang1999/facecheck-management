package cn.edu.zjut.action;

import cn.edu.zjut.po.Announcement;
import cn.edu.zjut.service.IMakeAnnService;
import org.springframework.beans.factory.annotation.Autowired;

public class MakeAnnAction {
    private Announcement announcement;
   // @Autowired
    private IMakeAnnService makeAnnService;

    public String makeAnn() {
        try {
            if (makeAnnService.makeAnn(announcement)) {
                return "success";
            } else
                return "fail";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
