package com.neo.exception;

public enum ErrorCode {

    SUCCESS(0,"成功"),
    FAILURE(100500,"系统错误");

    private final int code;
    private final String message;

    ErrorCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
