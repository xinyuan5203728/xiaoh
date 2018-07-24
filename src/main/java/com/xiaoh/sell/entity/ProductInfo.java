package com.xiaoh.sell.entity;
/**
 * @Package com.xiaoh.sell.entity
 * @Description: ${TODO}
 * @author huangyong
 * @date 2018/7/13 11:21
 */

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**

 **/
@Table(name="product_info")
@Entity
@DynamicUpdate
@Data
public class ProductInfo {
    @Id
    private String productId;
    /**
    　* @Description: 产品名称
    **/
    private String productName;
    /**
    　* @Description: 商品价格
    **/
    private BigDecimal productPrice;
    /**
    　* @Description:库存
    **/
    private int productStock;
    /**
    　* @Description: 商品描述
    **/
    private String productDescription;
    /**
    　* @Description: 缩略图
    **/
    private String productIcon;
    /**
    　* @Description: 商品状态,0正常1下架
    **/
    private int productStatus;
    /**
    　* @Description: 类目编号
    **/
    private int categoryType;

    private Date createTime;

    private Date updateTime;

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

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
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

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
