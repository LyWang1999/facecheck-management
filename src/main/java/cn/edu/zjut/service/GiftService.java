package cn.edu.zjut.service;

import cn.edu.zjut.dao.GiftMapper;
import cn.edu.zjut.dao.StuGiftMapper;
import cn.edu.zjut.po.Gift;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GiftService implements IGiftService {
    private Map<String,Gift> request;
    @Autowired
    private GiftMapper giftMapper;
    @Autowired
    private StuGiftMapper stuGiftMapper;

    /**
     * 获取所有礼品信息
     */
    @Override
    public List<Gift> getAllGift() {
        List<Gift> list = new ArrayList<>();
        try {
            list = giftMapper.selectAllGift();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 删除某个指定的礼品
     */
    @Override
    public void deleteGift(int gift_id) {
        try {
            giftMapper.deleteById(gift_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获得指定礼品的信息
     */
    @Override
    public boolean getGiftById(int gift_id) {
        ActionContext ctx = ActionContext.getContext();
        request = (Map)ctx.get("request");
        try {
            Gift gift = giftMapper.selectGiftById(gift_id);
            request.put("gift",gift);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 修改指定礼品的数量
     */
    @Override
    public boolean updateGift(Gift gift) {
        try {
            if (giftMapper.updateGift(gift) > 0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * 增加礼品
     */
    @Override
    public boolean insertGift(Gift gift) {
        try {
            giftMapper.insertGift(gift);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
