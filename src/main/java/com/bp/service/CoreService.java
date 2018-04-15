package com.bp.service;

import com.bp.po.OrderDetail;
import com.bp.po.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CoreService extends PageService{

    @Transactional
    Integer insertOrderDetail(OrderDetail orderDetail);

    @Transactional
    Integer insertUser(User user);

    @Transactional
    List<OrderDetail> queryOrderDetailList(OrderDetail orderDetail);

    @Transactional
    List<User> queryUserList(User user);
}
