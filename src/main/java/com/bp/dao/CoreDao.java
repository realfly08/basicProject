package com.bp.dao;


import com.bp.po.*;

import java.util.List;
import java.util.Map;

public interface CoreDao {

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

    Integer insertPhoneRecord(PhoneRecord phoneRecord);

    List<Agency> queryAgencyByTime(Map paramsMap);

    List<OrderDetail> queryOrderDetailByTime(Map paramsMap);

    List<Order> queryOrderByTime(Map paramsMap);

    List<User> queryUserByTime(Map paramsMap);

    List<PhoneRecord> queryPhoneRecord(PhoneRecord phoneRecord);
}

