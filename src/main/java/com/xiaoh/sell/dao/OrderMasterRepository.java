package com.xiaoh.sell.dao;

import com.xiaoh.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author huangyong
 * @Package com.xiaoh.sell.dao
 * @Description: ${TODO}
 * @date 2018/7/16 14:54
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
