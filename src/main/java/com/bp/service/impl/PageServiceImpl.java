package com.bp.service.impl;

import com.bp.dao.CoreDao;
import com.bp.po.OrderDetail;
import com.bp.po.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("coreService")
public class PageServiceImpl extends AbstractPageService {
    @Resource
    CoreDao coreDao;

    @Override
    public Integer insertOrderDetail(OrderDetail orderDetail) {
        return coreDao.insertOrderDetail(orderDetail);
    }

    @Override
    public Integer insertUser(User user) {
        return coreDao.insertUser(user);
    }

    @Override
    public List<OrderDetail> queryOrderDetailList(OrderDetail orderDetail) {
        return coreDao.queryOrderDetailList(orderDetail);
    }

    @Override
    public List<User> queryUserList(User user) {
        return coreDao.queryUserList(user);
    }

}
