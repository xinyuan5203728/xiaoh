package com.xiaoh.sell.service.impl;
/**
 * @Package com.xiaoh.sell.service.impl
 * @Description: ${TODO}
 * @author huangyong
 * @date 2018/6/30 10:53
 */

import com.xiaoh.sell.dao.ProductCategoryRepository;
import com.xiaoh.sell.dto.ProductCategory;
import com.xiaoh.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**

 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }

}
