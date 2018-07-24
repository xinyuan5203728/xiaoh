package com.xiaoh.sell.service;

import com.xiaoh.sell.entity.ProductCategory;

import java.util.List;

/**
 * @author huangyong
 * @Title: CategoryService
 * @Package com.xiaoh.sell.service
 * @Description: ${TODO}
 * @date 2018/6/30 10:43
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);

}
