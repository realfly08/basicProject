package com.bp.QueryPO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class QueryObject<T> {
    T t;
    Integer page;
    Integer row;
    @JsonFormat(pattern="yyyy-MM-dd")
    Date fromDate;
    Date toDate;

    public T getQueryObj() {
        return t;
    }

    public void setQueryObj(T t) {
        this.t = t;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
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
