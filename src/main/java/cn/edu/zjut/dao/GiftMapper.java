package cn.edu.zjut.dao;

import cn.edu.zjut.po.Gift;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftMapper {
    public List<Gift> selectAllGift();

    public Gift selectGiftById(int gift_id);

    public Gift selectGiftByName(String gift_name);

    public int updateGift(Gift gift);

    public void insertGift(Gift gift);

    public void deleteById(int gift_id);
}
