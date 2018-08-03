package com.xiaoh.sell.service.impl;
/**
 * @Package com.xiaoh.sell.service.impl
 * @Description: ${TODO}
 * @author huangyong
 * @date 2018/7/16 17:59
 */

import com.xiaoh.sell.common.enums.ResultEnum;
import com.xiaoh.sell.common.exception.SellException;
import com.xiaoh.sell.common.util.KeyUtil;
import com.xiaoh.sell.dao.OrderDetailRepository;
import com.xiaoh.sell.dao.OrderMasterRepository;
import com.xiaoh.sell.dto.CartDto;
import com.xiaoh.sell.dto.OrderDto;
import com.xiaoh.sell.entity.OrderDetail;
import com.xiaoh.sell.entity.OrderMaster;
import com.xiaoh.sell.entity.ProductInfo;
import com.xiaoh.sell.service.OrderService;
import com.xiaoh.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Override
    @Transactional
    public OrderDto create(OrderDto orderDto) {
        BigDecimal orderAmount = new BigDecimal(0);
        String orderId=KeyUtil.getUniqueKey();
        //查询商品
        for (OrderDetail orderDetail : orderDto.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXISTS);
            }
            //计算订单总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);

            //订单详情入库
            orderDetailRepository.save(orderDetail);
        }
        //写入订单数据库(OrderMaster,OrderDetail)
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDto,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(0);
        orderMaster.setPayStatus(0);
        orderMasterRepository.save(orderMaster);
        //扣库存,多线程，存在问题，后期要修改
        List<CartDto> cartDtoList=new ArrayList<>();
        cartDtoList=orderDto.getOrderDetailList().stream().map(e ->
                new CartDto(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decreaseStock(cartDtoList);

        return orderDto;
    }

    @Override
    public OrderDto findOne(String orderId) {
        OrderMaster orderMaster=orderMasterRepository.findOne(orderId);
        if(orderMaster == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXISTS);
        }
        List<OrderDetail> orderDetailList=orderDetailRepository.findByOrderId(orderId);
        if(orderDetailList ==null){
            throw new SellException(ResultEnum.ORDER_DETAIL_NOT_EXISTS);
        }
        OrderDto orderDto=new OrderDto();
        BeanUtils.copyProperties(orderMaster,orderDto);
        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }

    @Override
    public Page<OrderDto> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDto cancel(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto finished(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto paid(OrderDto orderDto) {
        return null;
    }
}
