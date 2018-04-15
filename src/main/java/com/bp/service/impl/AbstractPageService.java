package com.bp.service.impl;

import com.bp.po.IdentifiableDateRange;
import com.bp.po.OrderDetail;
import com.bp.po.User;
import com.bp.service.CoreService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;

@Component("coreService")
public abstract class AbstractPageService implements CoreService {

    @Override
    public final Object queryByPage(IdentifiableDateRange queryObject) {
        initialPager(queryObject);
        if(queryObject instanceof OrderDetail){
            return this.queryOrderDetailList((OrderDetail) queryObject);
        }else if (queryObject instanceof User){
            return this.queryUserList((User) queryObject);
        }
        return null;
    }

    private void initialPager(IdentifiableDateRange queryObject) {
        if(queryObject.getPageNum()!=null && queryObject.getPageSize()!=null){
            PageHelper.startPage(queryObject.getPageNum(), queryObject.getPageSize());
        }
    }
}
