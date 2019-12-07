package com.github.njupt.common.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/9 10:07
 * @Description:
 */
@Data
public class ResponseMsgDTO {
    private int code;
    private String msg;
    private Object data;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    public ResponseMsgDTO(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
        this.time = new Date();
    }

    public ResponseMsgDTO(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.time = new Date();
    }
}
