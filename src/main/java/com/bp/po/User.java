package com.bp.po;

import com.bp.QueryPO.QueryObject;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User extends QueryObject {
    String user_name;
    String phone;
    Integer sex;
    String soft_del;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date create_time;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSoft_del() {
        return soft_del;
    }

    public void setSoft_del(String soft_del) {
        this.soft_del = soft_del;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
