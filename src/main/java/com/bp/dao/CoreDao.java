package com.bp.dao;


import com.bp.po.*;

import java.util.List;

public interface CoreDao {

    Integer insertOrderDetail(OrderDetail orderDetail);

    Integer insertUser(User user);

    List<OrderDetail> queryOrderDetailList(OrderDetail orderDetail);

    List<User> queryUserList(User user);


}

