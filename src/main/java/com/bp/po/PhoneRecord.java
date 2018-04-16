package com.bp.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.bp.QueryPO.QueryObject;

public class PhoneRecord extends QueryObject {
    @Excel(name = "电话", orderNum = "0")
    String phone;
    @Excel(name = "经销商", orderNum = "1")
    String agent_name;
    @Excel(name = "省", orderNum = "2")
    String province;
    @Excel(name = "市", orderNum = "4")
    String city;

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
}
