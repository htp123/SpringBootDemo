package com.example.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/27.
 */

public class JsonResult implements Serializable{

    private String status = null;

    private Object result = null;

    public JsonResult status(String status) {
        this.status = status;
        return this;
    }

    // Getter Setter

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

