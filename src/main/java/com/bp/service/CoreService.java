package com.bp.service;

import com.bp.po.*;

import java.util.List;

public interface CoreService {

    Integer insertAgency(Agency agency);

    Integer insertBrand(Brand brand);

    Integer insertCar(Car car);

    Integer insertChannel(Channel channel);

    Integer insertCity(City city);

    Integer insertOrder(Order order);

    Integer insertOrderDetail(OrderDetail orderDetail);

    Integer insertProvince(Province province);

    Integer insertSupervisor(Supervisor supervisor);

    Integer insertSupervisorEvent(SupervisorEvent provinceEvent);

    Integer insertUser(User user);

    List<Agency> queryAgencyList(Agency agency, Integer page, Integer rows);

    List<OrderDetail> queryOrderDetailList(OrderDetail orderDetail);

    List<Order> queryOrderList(Order order, Integer page, Integer rows);

    List<User> queryUserList(User user, Integer page, Integer rows);
}
