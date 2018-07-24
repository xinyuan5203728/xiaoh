package com.xiaoh.sell.common.util;
/**
 * @Package com.xiaoh.sell.common.util
 * @Description: ${TODO}
 * @author huangyong
 * @date 2018/7/17 9:52
 */

/**

 **/
public class KeyUtil {
    /**
    　* @Description: 生成唯一主键
    **/
    public static String getUniqueKey(){
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }
}
