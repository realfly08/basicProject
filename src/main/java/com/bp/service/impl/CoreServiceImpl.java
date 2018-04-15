package com.bp.service.impl;

import com.bp.dao.CoreDao;
import com.bp.po.*;
import com.bp.service.CoreService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("coreService")
public class CoreServiceImpl implements CoreService {
    @Resource
    CoreDao coreDao;
    @Override
    public Integer insertAgency(Agency agency) {
        return coreDao.insertAgency(agency);
    }

    @Override
    public Integer insertBrand(Brand brand) {
        return coreDao.insertBrand(brand);
    }

    @Override
    public Integer insertCar(Car car) {
        return coreDao.insertCar(car);
    }

    @Override
    public Integer insertChannel(Channel channel) {
        return coreDao.insertChannel(channel);
    }

    @Override
    public Integer insertCity(City city) {
        return coreDao.insertCity(city);
    }

    @Override
    public Integer insertOrder(Order order) {
        return coreDao.insertOrder(order);
    }

    @Override
    public Integer insertOrderDetail(OrderDetail orderDetail) {
        return coreDao.insertOrderDetail(orderDetail);
    }

    @Override
    public Integer insertProvince(Province province) {
        return coreDao.insertProvince(province);
    }

    @Override
    public Integer insertSupervisor(Supervisor supervisor) {
        return coreDao.insertSupervisor(supervisor);
    }

    @Override
    public Integer insertSupervisorEvent(SupervisorEvent supervisorEvent) {
        return coreDao.insertSupervisorEvent(supervisorEvent);
    }

    @Override
    public Integer insertUser(User user) {
        return coreDao.insertUser(user);
    }

    @Override
    public List<Agency> queryAgencyList(Agency agency,Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        return coreDao.queryAgencyList(agency);
    }

    @Override
    public List<OrderDetail> queryOrderDetailList(OrderDetail orderDetail) {
        PageHelper.startPage(orderDetail.getPageNum(),orderDetail.getPageSize());
        return coreDao.queryOrderDetailList(orderDetail);
    }

    @Override
    public List<Order> queryOrderList(Order order,Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        return null;
    }

    @Override
    public List<User> queryUserList(User user,Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        return null;
    }
}
