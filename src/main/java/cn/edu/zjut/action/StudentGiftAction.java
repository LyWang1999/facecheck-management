package cn.edu.zjut.action;

import cn.edu.zjut.po.GiftChange;
import cn.edu.zjut.service.IGiftService;
import cn.edu.zjut.service.IStuGiftService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class StudentGiftAction extends ActionSupport {
    @Autowired
    private IStuGiftService stuGiftService;
    @Autowired
    private IGiftService giftService;
    private GiftChange giftChange;

    public void setGiftService(IGiftService giftService) {
        this.giftService = giftService;
    }

    public IGiftService getGiftService() {
        return giftService;
    }

    public GiftChange getGiftChange() {
        return giftChange;
    }

    public void setGiftChange(GiftChange giftChange) {
        this.giftChange = giftChange;
    }

    List<GiftChange> giftChanges = new ArrayList<>();

    public List<GiftChange> getGiftChanges() {
        return giftChanges;
    }

    public void setGiftChanges(List<GiftChange> giftChanges) {
        this.giftChanges = giftChanges;
    }

    public IStuGiftService getStuGiftService() {
        return stuGiftService;
    }

    public void setStuGiftService(IStuGiftService stuGiftService) {
        this.stuGiftService = stuGiftService;
    }

    /**
     * 查看请求兑换的信息
     */
    public String lookStudentGift() {
        giftChanges = stuGiftService.getStudentGift();
        return "success-lookStudentGift";
    }

    /**
     * 允许兑换后修改兑换结果
     */

    public String applyChange() {
        stuGiftService.updateStuGift(giftChange.getSg().getResult(), giftChange.getSg().getAutoid());
        giftChanges = stuGiftService.getStudentGift();
        return "success-applyChange";
    }

    /**
     * 拒绝兑换后还原礼品数目，删除该礼品请求信息
     */
    public String refuseChange() {
        if (!giftChange.getSg().getResult()) {
//            giftService.changeQuantity(giftChange.getSg().getGift_id(), giftChange.getSg().getQuantity());
            stuGiftService.deleteStuGift(giftChange.getSg().getAutoid());
        }
        giftChanges = stuGiftService.getStudentGift();
        return "success-refuseChange";
    }

}
