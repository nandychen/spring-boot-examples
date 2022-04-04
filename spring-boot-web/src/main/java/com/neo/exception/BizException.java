package com.neo.exception;

public class BizException extends RuntimeException {

    private final int code;
    private final String message;

    public BizException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BizException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
