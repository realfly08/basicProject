package com.bp.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.bp.QueryPO.QueryObject;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PhoneRecord extends QueryObject {
    @Excel(name = "电话", orderNum = "0")
    String phone;
    @Excel(name = "经销商", orderNum = "1")
    String agent_name;
    @Excel(name = "省", orderNum = "2")
    String province;
    @Excel(name = "市", orderNum = "4")
    String city;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Excel(name = "时间",  format = "yyyy-MM-dd HH:mm:ss", orderNum = "5")
    Date create_time;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
