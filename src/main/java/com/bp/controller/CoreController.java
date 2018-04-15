package com.bp.controller;

import com.bp.po.OrderDetail;
import com.bp.po.User;
import com.bp.service.CoreService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class CoreController {
    private static final Logger logger = LoggerFactory.getLogger(CoreController.class);
    @Resource
    private CoreService coreService;


    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public Integer insertUser(@RequestBody User user) {
        return coreService.insertUser(user);
    }


    @RequestMapping(value = "/insertOrderdetail", method = RequestMethod.POST)
    public Integer insertOrderDetail(@RequestBody OrderDetail orderdetail) {
        return coreService.insertOrderDetail(orderdetail);
    }


    @RequestMapping(value = "/queryOrderDetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> queryOrderDetail1(@RequestBody OrderDetail orderDetail) {
        List<OrderDetail> orderDetails = (List<OrderDetail>) coreService.queryByPage(orderDetail);
        Map<String, Object> reqult = addPageInfo2Reqult(orderDetails);
        return reqult;
    }


    @RequestMapping(value = "/queryUser", method = RequestMethod.POST)
    public Map<String, Object> queryUser(@RequestBody User user) {
        List<User> users = (List<User>) coreService.queryByPage(user);
        Map<String, Object> reqult = addPageInfo2Reqult(users);
        return reqult;
    }



    private Map<String, Object> addPageInfo2Reqult(Object list) {
        Map<String, Object> map = new HashMap<>();
        map.put("results", list);
        PageInfo<Object> pageInfo = new PageInfo((List) list);
        map.put("curr_page", pageInfo.getPageNum());
        map.put("page_size", pageInfo.getPageSize());
        map.put("total", pageInfo.getTotal());
        map.put("code", 20000);
        return map;
    }
}