package com.xiaoh.sell.common.util;
/**
 * @Package com.xiaoh.sell.common.util
 * @Description: ${TODO}
 * @author huangyong
 * @date 2018/7/13 16:03
 */

import com.xiaoh.sell.VO.ResultVO;

/**

 **/
public class ResultVoUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setData(object);
        resultVO.setCode("0");
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }
    public static ResultVO error(String code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
