package com.bp.service.impl;

import com.bp.QueryPO.QueryObject;
import com.bp.dao.CoreDao;
import com.bp.po.*;
import com.bp.service.CoreService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
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
    public Integer insertPhoneRecord(PhoneRecord phoneRecord) {
        return coreDao.insertPhoneRecord(phoneRecord);
    }

    /*  public List<Agency> queryAgencyList(Agency agency, String fromDate, String toDate, Integer page, Integer rows){
          Map paramsMap = new HashMap<String,Object>();
          if(agency==null){
              agency = new Agency();
          }
          if(!StringUtils.isNullOrEmpty(fromDate)){
              paramsMap.put("fromDate",fromDate);
          }
          if(!StringUtils.isNullOrEmpty(toDate)){
              paramsMap.put("toDate",toDate);
          }
          paramsMap.put("agency",agency);
          PageHelper.startPage(page,rows);
          return coreDao.queryAgencyByTime(paramsMap);
      }*/
/*    public List<Order> queryOrderList(Order order, String fromDate, String toDate, Integer page, Integer rows){
        Map paramsMap = new HashMap<String,Object>();
        if(order==null){
            order = new Order();
        }
        if(!StringUtils.isNullOrEmpty(fromDate)){
            paramsMap.put("fromDate",fromDate);
        }
        if(!StringUtils.isNullOrEmpty(toDate)){
            paramsMap.put("toDate",toDate);
        }
        paramsMap.put("order",order);
        PageHelper.startPage(page,rows);
        return coreDao.queryOrderByTime(paramsMap);
    }*/
    @Override
    public List<OrderDetail> queryOrderDetail(OrderDetail orderDetail) {
        initPager(orderDetail);
        return coreDao.queryOrderDetail(orderDetail);
    }


    @Override
    public List<User> queryUser(User user) {
        initPager(user);
        return coreDao.queryUser(user);
    }

    @Override
    public List<PhoneRecord> queryPhoneRecord(PhoneRecord phoneRecord) {
        initPager(phoneRecord);
        return coreDao.queryPhoneRecord(phoneRecord);
    }

    private void initPager(QueryObject queryObject) {
        if (queryObject.getPageNum() != null && queryObject.getPageSize() != null) {
            PageHelper.startPage(queryObject.getPageNum(), queryObject.getPageSize());
        }
    }
}
