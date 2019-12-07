package com.github.njupt.campus.pojo.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WaterFeeAccount {
    private Long campusCardId;
    private Integer waterFeeBalance;
}
