package com.bp.controller;

import com.bp.Util.FileUtil;
import com.bp.po.OrderDetail;
import com.bp.po.PhoneRecord;
import com.bp.service.CoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@CrossOrigin(origins="*" )
@RestController
public class ExcelController {

   ExecutorService executorService = Executors.newCachedThreadPool();

	protected static final Logger logger = LoggerFactory.getLogger(ExcelController.class);

	@Resource
	private CoreService coreService;

    @RequestMapping(value = "/orderDetailExcel",method = RequestMethod.GET)
	public void downOrderDetail(OrderDetail orderDetail, HttpServletResponse response) throws Exception {
		List<OrderDetail> list = coreService.queryOrderDetail(orderDetail);
		response.setHeader("content-Type", "application/vnd.ms-excel");
		FileUtil.exportExcel(list,"orderDetail","orderDetail",OrderDetail.class,"订单.xls",response);
	}

	@RequestMapping(value = "/phoneRecordExcel",method = RequestMethod.GET)
	public void downloadPhoneRecord(PhoneRecord phoneRecord, HttpServletResponse response) throws Exception {
		List<PhoneRecord> list = coreService.queryPhoneRecord(phoneRecord);
		response.setHeader("content-Type", "application/vnd.ms-excel");
		FileUtil.exportExcel(list,"phoneRecord","phoneRecord",OrderDetail.class,"信息.xls",response);
	}

/*	@RequestMapping(value = "/testdown",method = RequestMethod.GET)
	public void testDownLoad( HttpServletResponse response) throws Exception {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setName("xxxx");
		List<OrderDetail> list = coreService.queryOrderDetailList(orderDetail,null,null,null,null);
		response.setHeader("content-Type", "application/vnd.ms-excel");
		FileUtil.exportExcel(list,"orderDetail","orderDetail",OrderDetail.class,"订单.xls",response);
	}*/
	
}