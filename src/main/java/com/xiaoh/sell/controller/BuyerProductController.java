package com.xiaoh.sell.controller;
/**
 * @Package com.xiaoh.sell.controller
 * @Description: 买家商品
 * @author huangyong
 * @date 2018/7/13 14:46
 */

import com.xiaoh.sell.VO.ProductInfoVO;
import com.xiaoh.sell.VO.ProductVO;
import com.xiaoh.sell.VO.ResultVO;
import com.xiaoh.sell.common.util.ResultVoUtil;
import com.xiaoh.sell.entity.ProductCategory;
import com.xiaoh.sell.entity.ProductInfo;
import com.xiaoh.sell.service.CategoryService;
import com.xiaoh.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**

 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有商品
        List<ProductInfo> productInfoList=productService.findUpAll();

        //2.查询所有类目
        List<Integer> categoryTypeList=productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);
        List<ProductVO> productVOList=new ArrayList<ProductVO>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList=new ArrayList<ProductInfoVO>();
            for(ProductInfo productInfo: productInfoList){
                if(productInfo.getCategoryType()==productCategory.getCategoryType()){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    /*productInfoVO.setProductId(productInfo.getProductId());
                    productInfoVO.setProductName(productInfo.getProductName());
                    productInfoVO.setProductPrice(productInfo.getProductPrice());
                    productInfoVO.setProductDescription(productInfo.getProductDescription());
                    productInfoVO.setProductIcon(productInfo.getProductIcon());*/
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVoUtil.success(productVOList);
    }



}
