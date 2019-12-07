package com.github.njupt.campus.dao;

import com.github.njupt.campus.pojo.entity.CampusCard;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/7/26 16:39
 * @Description:
 */
@Mapper
@Component
public interface CampusCardDao {
    int insertCampusCard(CampusCard campusCard);

    int deleteCampusCard(Long id);

    int updateCampusCard(CampusCard campusCard);

    CampusCard getCampusCardByCardId(Long cardId);

    CampusCard getCampusCardByStuId(Integer stuId);

    List<CampusCard> listCampusCards();
}
