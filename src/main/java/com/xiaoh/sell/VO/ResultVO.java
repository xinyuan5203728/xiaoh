package com.xiaoh.sell.VO;
/**
 * @Package com.xiaoh.sell.VO
 * @Description: ${TODO}
 * @author huangyong
 * @date 2018/7/13 14:55
 */

/**

 **/
public class ResultVO<T> {
    private String code;
    private String msg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
