package com.xiaoh.sell.service;

import com.xiaoh.sell.dto.CartDto;
import com.xiaoh.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author huangyong
 * @Package com.xiaoh.sell.service
 * @Description: ${TODO}
 * @date 2018/7/13 14:19
 */
public interface ProductService {
    ProductInfo findOne(String productId);
    /**
    　* @Description: 查询所有上架商品
    **/
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);
    //加库存
    void increaseStock(List<CartDto> cartDtos);

    //减库存
    void decreaseStock(List<CartDto> cartDtos);

}
