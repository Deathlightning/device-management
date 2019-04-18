package xyz.kingsword.gateway.aop;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
    UNAUTHORIZED(-2, "未授权"),
    UN_LOGIN(-3, "未登录"),
    UNKNOWN_ACCOUNT(-4, "账号或密码错误"),
    MAX_WRONG_TIMES(-5, "达到错误次数上限"),
    LOCKED(-6, "账号被锁定");
    private int code;
    private String message;

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
