package com.ziroom.ups.exception;

/**
 * @author
 * @create 2018-12-15 21:47
 * Description:
 */
public class DataException extends RuntimeException {
    private static final long serialVersionUID = -8606857178711063389L;

    public DataException() {
        super();
    }

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataException(Throwable cause) {
        super(cause);
    }

    protected DataException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
