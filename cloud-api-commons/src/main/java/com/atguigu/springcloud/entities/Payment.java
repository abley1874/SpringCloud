package com.atguigu.springcloud.entities;

/**
 *  支付业务的实体类
 */
public class Payment {

    private Long id;
    private String serial;

    public Payment(){

    }

    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
