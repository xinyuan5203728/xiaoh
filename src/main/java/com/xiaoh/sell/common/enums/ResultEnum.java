package com.xiaoh.sell.common.enums;

/**
 * @author huangyong
 * @Package com.xiaoh.sell.common.enums
 * @Description: ${TODO}
 * @date 2018/7/17 9:08
 */
public enum ResultEnum {
    PRODUCT_NOT_EXISTS(10,"商品不存在"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
