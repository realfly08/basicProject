package com.bp.service;

import com.bp.po.IdentifiableDateRange;
import org.springframework.transaction.annotation.Transactional;

public interface PageService{
    @Transactional
    Object queryByPage(IdentifiableDateRange queryObject);
}
