package cn.edu.zjut.service;

import cn.edu.zjut.po.GiftChange;

import java.util.List;

public interface IStuGiftService {
    List<GiftChange> getStudentGift();

    int getListSize(int gift_id);

    void updateStuGift(Boolean result, int autoid);

    void deleteStuGift(int autoid);
}
