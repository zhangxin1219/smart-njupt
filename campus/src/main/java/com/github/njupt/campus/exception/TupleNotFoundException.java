package com.github.njupt.campus.exception;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/20 15:56
 * @Description:
 */
public class TupleNotFoundException extends RuntimeException {
    public TupleNotFoundException() {
        super();
    }

    public TupleNotFoundException(String message) {
        super(message);
    }

    public TupleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TupleNotFoundException(Throwable cause) {
        super(cause);
    }
}
