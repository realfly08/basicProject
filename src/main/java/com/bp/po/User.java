package com.bp.po;

import java.io.Serializable;

public class User {
    String user_name;
    String phone;
    String sex;
    String soft_del;
    String create_time;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSoft_del() {
        return soft_del;
    }

    public void setSoft_del(String soft_del) {
        this.soft_del = soft_del;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
