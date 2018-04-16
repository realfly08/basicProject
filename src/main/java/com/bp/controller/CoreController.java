package com.bp.controller;

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
@RestController
public class CoreController {

   ExecutorService executorService = Executors.newCachedThreadPool();

	protected static final Logger logger = LoggerFactory.getLogger(CoreController.class);

	@Resource
	private CoreService coreService;


    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        coreService.insertUser(user);
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

    @RequestMapping(value = "/queryUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryUserList(@RequestBody User user) throws ExecutionException, InterruptedException {
        List<User> users = coreService.queryUser(user);
        return getResult(users);
    }

    @RequestMapping(value = "/queryOrderDetail",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryOrderDetail1(@RequestBody OrderDetail orderDetail) throws ExecutionException, InterruptedException {
        List<OrderDetail> orderDetails = coreService.queryOrderDetail(orderDetail);

        return getResult(orderDetails);
    }



    @RequestMapping(value = "/queryPhoneRecord",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryPhoneRecord(@RequestBody PhoneRecord phoneRecord) throws ExecutionException, InterruptedException {
        List<PhoneRecord> phoneRecords = coreService.queryPhoneRecord(phoneRecord);
        return getResult(phoneRecords);
    }


    private Map<String, Object> getResult(List results) {
        Map<String ,Object> map = new HashMap<>();
        map.put("result",results);
        PageInfo<Object> pageInfo = new PageInfo<>(results);
        map.put("curr_page",pageInfo.getPageNum());
        map.put("page_size",pageInfo.getPageSize());
        map.put("total",pageInfo.getTotal());
        map.put("code",20000);
        return map;
    }
}