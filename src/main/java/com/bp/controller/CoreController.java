package com.bp.controller;

import com.bp.po.*;
import com.bp.service.CoreService;
import com.bp.service.impl.CoreServiceImpl;
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
        return "cost" +(System.currentTimeMillis()) +"ms";
    }


    @RequestMapping(value = "/brand",method = RequestMethod.POST)
    public String insertBrand(@RequestBody Brand brand) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertBrand(brand);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "cost" +(System.currentTimeMillis()) +"ms";
    }


    @RequestMapping(value = "/car",method = RequestMethod.POST)
    public String insertCar(@RequestBody Car car) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertCar(car);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "cost" +(System.currentTimeMillis()) +"ms";
    }

    @RequestMapping(value = "/channel",method = RequestMethod.POST)
    public String insertChannel(@RequestBody Channel channel) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertChannel(channel);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "cost" +(System.currentTimeMillis()) +"ms";
    }

    @RequestMapping(value = "/city",method = RequestMethod.POST)
    public String insertCity(@RequestBody City city) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertCity(city);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "cost" +(System.currentTimeMillis()) +"ms";
    }


    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public String insertOrder(@RequestBody Order order) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertOrder(order);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "cost" +(System.currentTimeMillis()) +"ms";
    }

    @RequestMapping(value = "/orderdetail",method = RequestMethod.POST)
    public String insertOrderDetail(@RequestBody OrderDetail orderdetail) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertOrderDetail(orderdetail);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "cost" +(System.currentTimeMillis()) +"ms";
    }

    @RequestMapping(value = "/province",method = RequestMethod.POST)
    public String insertProvince(@RequestBody Province province) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertProvince(province);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "cost" +(System.currentTimeMillis()) +"ms";
    }

    @RequestMapping(value = "/supervisor",method = RequestMethod.POST)
    public String insertSupervisor(@RequestBody Supervisor supervisor) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertSupervisor(supervisor);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "cost" +(System.currentTimeMillis()) +"ms";
    }

    @RequestMapping(value = "/supervisorevent",method = RequestMethod.POST)
    public String insertSupervisorEvent(@RequestBody SupervisorEvent supervisorevent) throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        coreService.insertSupervisorEvent(supervisorevent);
        logger.debug(Thread.currentThread().getName()+"cost "+(System.currentTimeMillis()-time) + "ms");
        return "cost" +(System.currentTimeMillis()) +"ms";
    }

    @RequestMapping(value = "/queryAgency/{page}/{rows}",method = RequestMethod.POST)
    public List<Agency> queryAgency(@PathVariable("page") Integer page,@PathVariable("rows") Integer rows,@RequestBody Agency agency) throws ExecutionException, InterruptedException {

        return coreService.queryAgencyList(agency,page,rows);
    }
//
//    @RequestMapping(value = "/queryOrderDetail/{page}/{rows}",method = RequestMethod.POST)
//    public List<OrderDetail> queryOrderDetail(@PathVariable("page") Integer page,@PathVariable("rows") Integer rows,@RequestBody OrderDetail orderDetail) throws ExecutionException, InterruptedException {
//
//        return coreService.queryOrderDetailList(orderDetail,page,rows);
//    }

    @RequestMapping(value = "/queryOrderDetail",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryOrderDetail1(@RequestBody OrderDetail orderDetail) throws ExecutionException, InterruptedException {

        Map<String ,Object> map = new HashMap<String,Object>();
        List<OrderDetail> list = coreService.queryOrderDetailList(orderDetail);
        map.put("orders",list);

        PageInfo<OrderDetail> pageInfo = new PageInfo<OrderDetail>(list);


        map.put("curr_page",pageInfo.getPageNum());
        map.put("page_size",pageInfo.getPageSize());
        map.put("total",pageInfo.getTotal());
        map.put("code",20000);
        return map;
    }

    @RequestMapping(value = "/queryOrder/{page}/{rows}",method = RequestMethod.POST)
    public List<Order> queryOrder(@PathVariable("page") Integer page,@PathVariable("rows") Integer rows,@RequestBody Order order) throws ExecutionException, InterruptedException {
        return coreService.queryOrderList(order,page,rows);
    }

    @RequestMapping(value = "/queryUser/{page}/{rows}",method = RequestMethod.POST)
    public List<User> queryUser(@PathVariable("page") Integer page,@PathVariable("rows") Integer rows,@RequestBody User user) throws ExecutionException, InterruptedException {
        List<User> userList = coreService.queryUserList(user,page,rows);
        return userList;
    }
	
}