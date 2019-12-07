package com.github.njupt.campus.dao;

import com.github.njupt.campus.pojo.entity.WaterFeeAccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface WaterFeeAccountDao {
    List<WaterFeeAccount> listWaterFeeAccounts();

    WaterFeeAccount getWaterFeeAccountById(Long campusCardId);

    int updateWaterFeeAccountById(Long campusCardId, Integer waterFeeBalance);

    int addWaterFeeAccount(WaterFeeAccount waterFeeAccount);

    int deleteWaterFeeAccountById(Long campusCardId);

    int addWaterFeeBalanceById(Long campusCardId, Integer AddedWaterFee);
}
