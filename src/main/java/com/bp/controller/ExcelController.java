package com.bp.controller;

import com.bp.QueryPO.QueryObject;
import com.bp.Util.FileUtil;
import com.bp.po.*;
import com.bp.service.CoreService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@CrossOrigin(origins="*" )
@RestController    //使用restcontroller requestmapping不需要responsebody 自动返回JSON格式
public class ExcelController {

   ExecutorService executorService = Executors.newCachedThreadPool();

	protected static final Logger logger = LoggerFactory.getLogger(ExcelController.class);

	@Resource
	private CoreService coreService;

    @RequestMapping(value = "/orderDetailExcel",method = RequestMethod.POST)
    public void downOrderDetail(@RequestBody QueryObject<OrderDetail> queryObject, HttpServletResponse response) throws Exception {
        List<OrderDetail> list = coreService.queryOrderDetailList(queryObject.getQueryObj(),queryObject.getFromDate(),queryObject.getToDate(),null,null);
        response.setHeader("content-Type", "application/vnd.ms-excel");
        FileUtil.exportExcel(list,"orderDetail","orderDetail",OrderDetail.class,"订单.xls",response);
    }

    @RequestMapping(value = "/phoneRecordExcel",method = RequestMethod.POST)
    public void downloadPhoneRecord(@RequestBody QueryObject<PhoneRecord> queryObject, HttpServletResponse response) throws Exception {
        List<PhoneRecord> list = coreService.queryPhoneRecordList(queryObject.getQueryObj(),null,null);
        response.setHeader("content-Type", "application/vnd.ms-excel");
        FileUtil.exportExcel(list,"phoneRecord","phoneRecord",OrderDetail.class,"信息.xls",response);
    }

    @RequestMapping(value = "/testdown",method = RequestMethod.GET)
    public void testDownLoad( HttpServletResponse response) throws Exception {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setName("xxxx");
        List<OrderDetail> list = coreService.queryOrderDetailList(orderDetail,null,null,null,null);
        response.setHeader("content-Type", "application/vnd.ms-excel");
        FileUtil.exportExcel(list,"orderDetail","orderDetail",OrderDetail.class,"订单.xls",response);
    }
	
}