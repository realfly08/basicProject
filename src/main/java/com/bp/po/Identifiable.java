package com.bp.po;

import java.io.Serializable;

public class Identifiable implements Serializable{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
