package com.bp.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SupervisorEvent {
    String supervisor_id;
    String event_name;
    String ip;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date create_time;

    public String getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(String supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
