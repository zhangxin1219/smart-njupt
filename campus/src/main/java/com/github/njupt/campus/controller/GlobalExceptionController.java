package com.github.njupt.campus.controller;

import com.github.njupt.campus.exception.TupleNotFoundException;
import com.github.njupt.common.pojo.dto.ResponseMsgDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/19 13:34
 * @Description:
 */
@Slf4j
@RestControllerAdvice(value = "cn.star2.campus.eas.controller")
public class GlobalExceptionController {
    @ExceptionHandler({Exception.class})
    public ResponseMsgDTO handleException(Exception e) {
        log.error("[handleException] ", e);
        return new ResponseMsgDTO(2000, "发生了错误", null);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseMsgDTO handleException(NullPointerException e) {
        log.error("[handleException] ", e);
        return new ResponseMsgDTO(2001, "空指针异常", null);
    }

    @ExceptionHandler({TupleNotFoundException.class})
    public ResponseMsgDTO handleException(TupleNotFoundException e) {
        log.error("[handleException] ", e);
        return new ResponseMsgDTO(2002, "查询数据库元组为空", null);
    }
}
