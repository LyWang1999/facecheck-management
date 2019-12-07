package cn.edu.zjut.service;

import cn.edu.zjut.po.Gift;

import java.util.List;

public interface IGiftService {
    List<Gift> getAllGift();
    void deleteGift(int gift_id);
    boolean getGiftById(int gift_id);
    boolean updateGift(Gift gift);
    boolean insertGift(Gift gift);
}
