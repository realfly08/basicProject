package com.bp.QueryPO;

public class QueryObject<T> {
    T t;
    Integer page;
    Integer row;
    String fromDate;
    String toDate;

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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
}
