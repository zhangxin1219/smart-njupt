package com.github.njupt.campus.dao;

import com.github.njupt.campus.pojo.entity.NetworkFeeAccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface NetworkFeeAccountDao {
    List<NetworkFeeAccount> listNetworkFeeAccounts();

    NetworkFeeAccount getNetworkFeeAccountById(Long campusCardId);

    int updateNetworkFeeAccountById(Long campusCardId, Integer networkFeeBalance);

    int addNetworkFeeAccount(NetworkFeeAccount networkFeeAccount);

    int deleteNetworkFeeAccountById(Long campusCardId);

    int addNetworkFeeBalanceById(Long campusCardId, Integer AddedNetworkFee);

}
