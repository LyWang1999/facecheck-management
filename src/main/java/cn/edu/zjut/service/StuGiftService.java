package cn.edu.zjut.service;

import cn.edu.zjut.dao.StuGiftMapper;
import cn.edu.zjut.po.GiftChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StuGiftService implements IStuGiftService {
    @Autowired
    private StuGiftMapper stuGiftMapper;

    public StuGiftMapper getStuGiftMapper() {
        return stuGiftMapper;
    }

    public void setStuGiftMapper(StuGiftMapper stuGiftMapper) {
        this.stuGiftMapper = stuGiftMapper;
    }

    /**
     * 获得所有的兑换请求
     */
    @Override
    public List<GiftChange> getStudentGift() {
        List<GiftChange> list = new ArrayList<>();
        try {
            list = stuGiftMapper.selectStudentGift();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 修改兑换状态
     */
    @Override
    public void updateStuGift(Boolean result, int autoid) {
        try {
            stuGiftMapper.updateStudentGift(result, autoid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据礼品的ID得到该礼品未被兑换的请求数量
     */
    @Override
    public int getListSize(int gift_id) {
        List<GiftChange> list = new ArrayList<>();
        try {
            list = stuGiftMapper.selectByGiftId(gift_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.size();
    }

    /**
     * 根据兑换请求ID删除某个请求
     */
    @Override
    public void deleteStuGift(int autoid) {
        try {
            stuGiftMapper.deleteById(autoid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
