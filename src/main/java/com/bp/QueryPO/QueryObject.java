package com.bp.QueryPO;

import com.bp.po.Identifiable;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class QueryObject extends Identifiable {
    Integer pageNum;
    Integer pageSize;
    @JsonFormat(pattern="yyyy-MM-dd")
    Date fromDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    Date toDate;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
