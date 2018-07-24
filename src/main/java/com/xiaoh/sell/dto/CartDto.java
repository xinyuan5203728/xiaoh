package com.xiaoh.sell.dto;
/**
 * @Package com.xiaoh.sell.dto
 * @Description: 购物车
 * @author huangyong
 * @date 2018/7/19 15:09
 */


public class CartDto {
    /**
    　* @Description: 商品ID
    **/
    private String productId;
    /**
    　* @Description: 数量
    **/
    private Integer productQuantity;

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
