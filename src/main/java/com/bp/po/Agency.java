package com.bp.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Agency {
    String city_id;
    String agency_name;
    String agency_address;
    String connect_phone;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date create_time;

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getAgency_name() {
        return agency_name;
    }

    public void setAgency_name(String agency_name) {
        this.agency_name = agency_name;
    }

    public String getAgency_address() {
        return agency_address;
    }

    public void setAgency_address(String agency_address) {
        this.agency_address = agency_address;
    }

    public String getConnect_phone() {
        return connect_phone;
    }

    public void setConnect_phone(String connect_phone) {
        this.connect_phone = connect_phone;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
