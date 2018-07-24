package com.xiaoh.sell.VO;
/**
 * @Package com.xiaoh.sell.VO
 * @Description: ${TODO}
 * @author huangyong
 * @date 2018/7/13 15:11
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**

 **/
public class ProductInfoVO {
    @JsonProperty("id")
    private String productId;
    /**
     　* @Description: 产品名称
     **/
    @JsonProperty("name")
    private String productName;
    /**
     　* @Description: 商品价格
     **/
    @JsonProperty("price")
    private BigDecimal productPrice;

    /**
     　* @Description: 商品描述
     **/
    @JsonProperty("description")
    private String productDescription;

    /**
     　* @Description: 商品描述
     **/
    @JsonProperty("icon")
    private String productIcon;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }
}
