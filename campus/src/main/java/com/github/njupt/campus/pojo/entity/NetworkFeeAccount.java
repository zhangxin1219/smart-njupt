package com.github.njupt.campus.pojo.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NetworkFeeAccount {
    private Long campusCardId;
    private String password;
    private Integer networkFeeBalance;
}
