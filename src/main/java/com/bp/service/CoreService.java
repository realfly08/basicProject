package com.bp.service;

import com.bp.po.*;

import java.util.Date;
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

    Integer insertPhoneRecord(PhoneRecord phoneRecord);

    List<Agency> queryAgencyList(Agency agency, Date fromDate, Date toDate, Integer page, Integer rows);

    List<OrderDetail> queryOrderDetailList(OrderDetail orderDetail, Date fromDate, Date toDate, Integer page, Integer rows);

    List<PhoneRecord> queryPhoneRecordList(PhoneRecord phoneRecord, Integer page, Integer rows);

    List<Order> queryOrderList(Order order, Date fromDate, Date toDate, Integer page, Integer rows);

    List<User> queryUserList(User user, Date fromDate, Date toDate, Integer page, Integer rows);


}
