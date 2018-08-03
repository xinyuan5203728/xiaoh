package com.xiaoh.sell.service.impl;
/**
 * @Package com.xiaoh.sell.service.impl
 * @Description: ${TODO}
 * @author huangyong
 * @date 2018/7/13 14:25
 */

import com.xiaoh.sell.common.enums.ResultEnum;
import com.xiaoh.sell.common.exception.SellException;
import com.xiaoh.sell.dao.ProductInfoRepository;
import com.xiaoh.sell.dto.CartDto;
import com.xiaoh.sell.entity.ProductInfo;
import com.xiaoh.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**

 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(0);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDto> cartDtos) {
        for(CartDto cartDto:cartDtos){
            ProductInfo productInfo=findOne(cartDto.getProductId());
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXISTS);
            }
            Integer result=productInfo.getProductStock()+cartDto.getProductQuantity();
            if(result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDto> cartDtos) {
        for(CartDto cartDto:cartDtos){
            ProductInfo productInfo=findOne(cartDto.getProductId());
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXISTS);
            }
            Integer result=productInfo.getProductStock()-cartDto.getProductQuantity();
            if(result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }


}
