package com.xiaoh.sell.dao;

import com.xiaoh.sell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author huangyong
 * @Package com.xiaoh.sell.dao
 * @Description: ${TODO}
 * @date 2018/7/16 14:57
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);

}
