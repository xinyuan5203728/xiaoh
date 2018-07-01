package com.xiaoh.sell.dao;
/**
 * @Title: ${FILE_NAME}
 * @Package com.xiaoh.sell.dao
 * @Description: ${TODO}
 * @author huangyong
 * @date 2018/6/29 16:16
 */

import com.xiaoh.sell.dto.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**

 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
