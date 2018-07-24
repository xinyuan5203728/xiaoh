package com.xiaoh.sell.dao;

import com.xiaoh.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author huangyong
 * @Package com.xiaoh.sell.dao
 * @Description: ${TODO}
 * @date 2018/7/13 11:28
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
