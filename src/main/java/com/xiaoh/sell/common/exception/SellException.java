package com.xiaoh.sell.common.exception;
/**
 * @Package com.xiaoh.sell.common.exception
 * @Description: ${TODO}
 * @author huangyong
 * @date 2018/7/17 9:11
 */

import com.xiaoh.sell.common.enums.ResultEnum;

/**

 **/
public class SellException extends RuntimeException {
    private Integer code;
    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());

        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
