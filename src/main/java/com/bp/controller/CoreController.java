package com.bp.controller;

import com.bp.QueryPO.QueryObject;
import com.bp.po.*;
import com.bp.service.CoreService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@CrossOrigin(origins="*" )
@RestController    //使用restcontroller requestmapping不需要responsebody 自动返回JSON格式
public class CoreController {

   ExecutorService executorService = Executors.newCachedThreadPool();

	protected static final Logger logger = LoggerFactory.getLogger(CoreController.class);

	@Resource
	private CoreService coreService;


    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(@RequestBody User user) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertUser(user);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "写入成功";
    }


    @RequestMapping(value = "/brand",method = RequestMethod.POST)
    public String insertBrand(@RequestBody Brand brand) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertBrand(brand);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "写入成功";
    }


    @RequestMapping(value = "/car",method = RequestMethod.POST)
    public String insertCar(@RequestBody Car car) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertCar(car);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "写入成功";
    }

    @RequestMapping(value = "/channel",method = RequestMethod.POST)
    public String insertChannel(@RequestBody Channel channel) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertChannel(channel);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "写入成功";
    }

    @RequestMapping(value = "/city",method = RequestMethod.POST)
    public String insertCity(@RequestBody City city) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertCity(city);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "写入成功";
    }


    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public String insertOrder(@RequestBody Order order) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertOrder(order);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "写入成功";
    }

    @RequestMapping(value = "/orderdetail",method = RequestMethod.POST)
    public String insertOrderDetail(@RequestBody OrderDetail orderdetail) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertOrderDetail(orderdetail);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "写入成功";
    }

    @RequestMapping(value = "/province",method = RequestMethod.POST)
    public String insertProvince(@RequestBody Province province) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertProvince(province);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "写入成功";
    }

    @RequestMapping(value = "/supervisor",method = RequestMethod.POST)
    public String insertSupervisor(@RequestBody Supervisor supervisor) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertSupervisor(supervisor);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "写入成功";
    }

    @RequestMapping(value = "/supervisorevent",method = RequestMethod.POST)
    public String insertSupervisorEvent(@RequestBody SupervisorEvent supervisorevent) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertSupervisorEvent(supervisorevent);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "写入成功";
    }

    @RequestMapping(value = "/phoneRecord",method = RequestMethod.POST)
    public String insertSupervisorEvent(@RequestBody PhoneRecord phoneRecord) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertPhoneRecord(phoneRecord);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "写入成功";
    }

    @RequestMapping(value = "/queryUserList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryUserList(@RequestBody QueryObject<User> queryObject) throws ExecutionException, InterruptedException {

        Map<String ,Object> map = new HashMap<String,Object>();
        List<User> users = coreService.queryUserList(queryObject.getQueryObj(),queryObject.getFromDate(),queryObject.getToDate(),queryObject.getPage(),queryObject.getRow());
        map.put("users",users);
        PageInfo<User> pageInfo = new PageInfo<User>(users);

        map.put("curr_page",pageInfo.getPageNum());
        map.put("page_size",pageInfo.getPageSize());
        map.put("total",pageInfo.getTotal());
        map.put("code",20000);
        return map;
    }

    @RequestMapping(value = "/queryOrderDetail",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryOrderDetail1(@RequestBody QueryObject<OrderDetail> queryObject) throws ExecutionException, InterruptedException {

        Map<String ,Object> map = new HashMap<String,Object>();
        List<OrderDetail> orderDetails = coreService.queryOrderDetailList(queryObject.getQueryObj(),queryObject.getFromDate(),queryObject.getToDate(),queryObject.getPage(),queryObject.getRow());
        map.put("orders",orderDetails);
        PageInfo<OrderDetail> pageInfo = new PageInfo<OrderDetail>(orderDetails);

        map.put("curr_page",pageInfo.getPageNum());
        map.put("page_size",pageInfo.getPageSize());
        map.put("total",pageInfo.getTotal());
        map.put("code",20000);
        return map;
    }

    @RequestMapping(value = "/queryPhoneRecord",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryPhoneRecord(@RequestBody QueryObject<PhoneRecord> queryObject) throws ExecutionException, InterruptedException {

        Map<String ,Object> map = new HashMap<String,Object>();
        List<PhoneRecord> phoneRecords = coreService.queryPhoneRecordList(queryObject.getQueryObj(),queryObject.getPage(),queryObject.getRow());
        map.put("phoneRecords",phoneRecords);
        PageInfo<PhoneRecord> pageInfo = new PageInfo<PhoneRecord>(phoneRecords);

        map.put("curr_page",pageInfo.getPageNum());
        map.put("page_size",pageInfo.getPageSize());
        map.put("total",pageInfo.getTotal());
        map.put("code",20000);
        return map;
    }
	
}