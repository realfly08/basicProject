package com.bp.po;

import java.io.Serializable;

public abstract class Identifiable implements Serializable {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
