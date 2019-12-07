package cn.edu.zjut.dao;

import cn.edu.zjut.po.GiftChange;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuGiftMapper {
    List<GiftChange> selectStudentGift();
    List<GiftChange> selectByGiftId(int gift_id);
    void updateStudentGift(Boolean result,int autoid);
    void deleteById(int id);
    void insert(GiftChange g);
}
