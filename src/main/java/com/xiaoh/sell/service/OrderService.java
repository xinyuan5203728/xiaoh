package com.xiaoh.sell.service;

import com.xiaoh.sell.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author huangyong
 * @Package com.xiaoh.sell.service
 * @Description: ${TODO}
 * @date 2018/7/16 17:47
 */
public interface OrderService {
    /**
    　* @Description: 创建订单
    **/
    OrderDto create(OrderDto orderDto);
    /**
    　* @Description: 查找订单
    **/
    OrderDto findOne(String orderId);
    /**
    　* @Description: 获取订单列表
    **/
    Page<OrderDto> findList(String buyerOpenid, Pageable pageable);
    /**
    　* @Description: 取消订单
    **/
    OrderDto cancel(OrderDto orderDto);
    /**
    　* @Description: 完结订单
    **/
    OrderDto finished(OrderDto orderDto);
    /**
    　* @Description: 支付订单
    **/
    OrderDto paid(OrderDto orderDto);
}
