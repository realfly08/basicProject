package com.bp.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderDetail {

    @Excel(name = "姓名", orderNum = "0")
    String name;
    @Excel(name = "性别", replace = {"男_1", "女_2"}, orderNum = "1")
    String sex;
    @Excel(name = "手机",  orderNum = "2")
    String mobile;
    @Excel(name = "省",  orderNum = "3")
    String province;
    @Excel(name = "市",  orderNum = "4")
    String city;
    @Excel(name = "经销商",  orderNum = "5")
    String agentName;
    @Excel(name = "经销商code",  orderNum = "6")
    String agentCode;
    @Excel(name = "车型",  orderNum = "7")
    String carType;
    @Excel(name = "车型code",  orderNum = "8")
    String carTypeCode;
    @Excel(name = "媒体名字",  orderNum = "9")
    String mediaName;
    @Excel(name = "媒体url",  orderNum = "10")
    String mediaUrl;
    @Excel(name = "主题",  orderNum = "11")
    String subject;
    @Excel(name = "途径",  orderNum = "12")
    String terminal;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间",  format = "yyyy-MM-dd HH:mm:ss", orderNum = "13")
    Date create_time;
    @Excel(name = "活动专题",  orderNum = "14")
    String is_activity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarTypeCode() {
        return carTypeCode;
    }

    public void setCarTypeCode(String carTypeCode) {
        this.carTypeCode = carTypeCode;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getIs_activity() {
        return is_activity;
    }

    public void setIs_activity(String is_activity) {
        this.is_activity = is_activity;
    }
}
